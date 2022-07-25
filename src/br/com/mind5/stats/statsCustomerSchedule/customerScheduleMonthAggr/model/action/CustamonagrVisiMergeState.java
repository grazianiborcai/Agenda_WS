package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.StateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrMerger;

public final class CustamonagrVisiMergeState extends ActionVisitorTemplateMerge<CustamonagrInfo, StateInfo> {
	
	public CustamonagrVisiMergeState(DeciTreeOption<CustamonagrInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return StateRootSelect.class;
	}
	
	
	
	@Override protected List<CustamonagrInfo> mergeHook(List<CustamonagrInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return CustamonagrMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
