package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.StateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveMerger;

public final class CustamoniveVisiMergeState extends ActionVisitorTemplateMerge<CustamoniveInfo, StateInfo> {
	
	public CustamoniveVisiMergeState(DeciTreeOption<CustamoniveInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return StateRootSelect.class;
	}
	
	
	
	@Override protected List<CustamoniveInfo> mergeHook(List<CustamoniveInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return CustamoniveMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
