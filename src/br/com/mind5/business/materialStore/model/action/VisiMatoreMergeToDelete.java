package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreMerger;
import br.com.mind5.business.materialStore.model.decisionTree.RootMatoreSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreMergeToDelete extends ActionVisitorTemplateMerge<MatoreInfo, MatoreInfo> {
	
	public VisiMatoreMergeToDelete(DeciTreeOption<MatoreInfo> option) {
		super(option, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return RootMatoreSelect.class;
	}
	
	
	
	@Override protected List<MatoreInfo> mergeHook(List<MatoreInfo> baseInfos, List<MatoreInfo> selectedInfos) {	
		return MatoreMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
