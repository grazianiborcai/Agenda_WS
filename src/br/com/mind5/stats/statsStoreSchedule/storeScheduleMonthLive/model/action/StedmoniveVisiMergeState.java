package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.StateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveMerger;

public final class StedmoniveVisiMergeState extends ActionVisitorTemplateMerge<StedmoniveInfo, StateInfo> {
	
	public StedmoniveVisiMergeState(DeciTreeOption<StedmoniveInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return StateRootSelect.class;
	}
	
	
	
	@Override protected List<StedmoniveInfo> mergeHook(List<StedmoniveInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return StedmoniveMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
