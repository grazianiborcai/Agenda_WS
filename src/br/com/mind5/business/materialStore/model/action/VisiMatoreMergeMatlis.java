package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.RootMatlisSelect;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreMergeMatlis extends ActionVisitorTemplateMerge<MatoreInfo, MatlisInfo> {
	
	public VisiMatoreMergeMatlis(DeciTreeOption<MatoreInfo> option) {
		super(option, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return RootMatlisSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> toActionClassHook(List<MatoreInfo> baseInfos) {
		return MatlisInfo.copyFrom(baseInfos);	
	}
	
	
	
	@Override protected List<MatoreInfo> mergeHook(List<MatoreInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return MatoreMerger.mergeWithMatlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
