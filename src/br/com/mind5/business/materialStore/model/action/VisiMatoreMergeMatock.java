package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.decisionTree.RootMatockSelect;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreMergeMatock extends ActionVisitorTemplateMergeV2<MatoreInfo, MatockInfo> {
	
	public VisiMatoreMergeMatock(DeciTreeOption<MatoreInfo> option) {
		super(option, MatockInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatockInfo>> getTreeClassHook() {
		return RootMatockSelect.class;
	}
	
	
	
	@Override protected List<MatoreInfo> mergeHook(List<MatoreInfo> baseInfos, List<MatockInfo> selectedInfos) {	
		return MatoreMerger.mergeWithMatock(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
