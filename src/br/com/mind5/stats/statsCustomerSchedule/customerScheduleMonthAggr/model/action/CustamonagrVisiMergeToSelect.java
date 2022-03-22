package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrMerger;

public final class CustamonagrVisiMergeToSelect extends ActionVisitorTemplateMerge<CustamonagrInfo, CustamonagrInfo> {
	
	public CustamonagrVisiMergeToSelect(DeciTreeOption<CustamonagrInfo> option) {
		super(option, CustamonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CustamonagrInfo>> getVisitorClassHook() {
		return CustamonagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CustamonagrInfo> mergeHook(List<CustamonagrInfo> baseInfos, List<CustamonagrInfo> selectedInfos) {	
		return CustamonagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
