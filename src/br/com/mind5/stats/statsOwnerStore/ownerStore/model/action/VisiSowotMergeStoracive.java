package br.com.mind5.stats.statsOwnerStore.ownerStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotMerger;
import br.com.mind5.stats.statsOwnerStore.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsOwnerStore.storeAccountLive.model.decisionTree.RootStoraciveSelect;

final class VisiSowotMergeStoracive extends ActionVisitorTemplateMerge<SowotInfo, StoraciveInfo> {
	
	public VisiSowotMergeStoracive(DeciTreeOption<SowotInfo> option) {
		super(option, StoraciveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoraciveInfo>> getTreeClassHook() {
		return RootStoraciveSelect.class;
	}
	
	
	
	@Override protected List<SowotInfo> mergeHook(List<SowotInfo> baseInfos, List<StoraciveInfo> selectedInfos) {	
		return SowotMerger.mergeWithStoracive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
