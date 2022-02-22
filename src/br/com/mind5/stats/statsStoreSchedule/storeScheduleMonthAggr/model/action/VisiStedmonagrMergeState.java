package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.RootStateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrMerger;

final class VisiStedmonagrMergeState extends ActionVisitorTemplateMerge<StedmonagrInfo, StateInfo> {
	
	public VisiStedmonagrMergeState(DeciTreeOption<StedmonagrInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return RootStateSelect.class;
	}
	
	
	
	@Override protected List<StedmonagrInfo> mergeHook(List<StedmonagrInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return StedmonagrMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
