package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonMerger;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.decisionTree.CustamonagrRootSelect;

public final class CustamonVisiMergeCustamonagr extends ActionVisitorTemplateMerge<CustamonInfo, CustamonagrInfo> {
	
	public CustamonVisiMergeCustamonagr(DeciTreeOption<CustamonInfo> option) {
		super(option, CustamonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustamonagrInfo>> getTreeClassHook() {
		return CustamonagrRootSelect.class;
	}
	
	
	
	@Override protected List<CustamonInfo> mergeHook(List<CustamonInfo> baseInfos, List<CustamonagrInfo> selectedInfos) {	
		return CustamonMerger.mergeWithStedmonagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
