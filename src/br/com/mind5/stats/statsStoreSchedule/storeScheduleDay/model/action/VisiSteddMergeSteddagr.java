package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddMerger;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.decisionTree.RootSteddagrSelect;

final class VisiSteddMergeSteddagr extends ActionVisitorTemplateMerge<SteddInfo, SteddagrInfo> {
	
	public VisiSteddMergeSteddagr(DeciTreeOption<SteddInfo> option) {
		super(option, SteddagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SteddagrInfo>> getTreeClassHook() {
		return RootSteddagrSelect.class;
	}
	
	
	
	@Override protected List<SteddInfo> mergeHook(List<SteddInfo> baseInfos, List<SteddagrInfo> selectedInfos) {	
		return SteddMerger.mergeWithSteddagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
