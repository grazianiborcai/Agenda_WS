package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotMerger;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.decisionTree.SowotiveRootSelect;

public final class SowotVisiMergeSowotive extends ActionVisitorTemplateMerge<SowotInfo, SowotiveInfo> {
	
	public SowotVisiMergeSowotive(DeciTreeOption<SowotInfo> option) {
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
