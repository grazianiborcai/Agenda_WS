package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.StolisRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotMerger;

public final class SowotVisiMergeStolis extends ActionVisitorTemplateMerge<SowotInfo, StolisInfo> {
	
	public SowotVisiMergeStolis(DeciTreeOption<SowotInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return StolisRootSearch.class;
	}
	
	
	
	@Override protected List<SowotInfo> mergeHook(List<SowotInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return SowotMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
