package br.com.mind5.stats.statsOwnerStore.ownerStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotMerger;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.decisionTree.SowotiveRootSelect;

final class VisiSowotMergeSowotive extends ActionVisitorTemplateMerge<SowotInfo, SowotiveInfo> {
	
	public VisiSowotMergeSowotive(DeciTreeOption<SowotInfo> option) {
		super(option, SowotiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotiveInfo>> getTreeClassHook() {
		return SowotiveRootSelect.class;
	}
	
	
	
	@Override protected List<SowotInfo> mergeHook(List<SowotInfo> baseInfos, List<SowotiveInfo> selectedInfos) {	
		return SowotMerger.mergeWithSowotive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
