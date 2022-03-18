package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrMerger;

public final class SteddagrVisiMergeToSelect extends ActionVisitorTemplateMerge<SteddagrInfo, SteddagrInfo> {
	
	public SteddagrVisiMergeToSelect(DeciTreeOption<SteddagrInfo> option) {
		super(option, SteddagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SteddagrInfo>> getVisitorClassHook() {
		return SteddagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SteddagrInfo> mergeHook(List<SteddagrInfo> baseInfos, List<SteddagrInfo> selectedInfos) {	
		return SteddagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
