package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveMerger;

public final class CustamoniveVisiMergeCalonth extends ActionVisitorTemplateMerge<CustamoniveInfo, CalonthInfo> {
	
	public CustamoniveVisiMergeCalonth(DeciTreeOption<CustamoniveInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelect.class;
	}
	
	
	
	@Override protected List<CustamoniveInfo> mergeHook(List<CustamoniveInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return CustamoniveMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
