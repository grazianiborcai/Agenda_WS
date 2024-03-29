package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.action;

import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.MonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info.SowotiveMerger;

public final class SowotiveVisiMergeMonth extends ActionVisitorTemplateMerge<SowotiveInfo, MonthInfo> {
	
	public SowotiveVisiMergeMonth(DeciTreeOption<SowotiveInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return MonthRootSelect.class;
	}
	
	
	
	@Override protected List<SowotiveInfo> mergeHook(List<SowotiveInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return SowotiveMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
