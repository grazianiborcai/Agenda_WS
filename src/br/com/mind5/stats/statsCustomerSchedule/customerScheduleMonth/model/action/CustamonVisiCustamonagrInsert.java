package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonMerger;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.decisionTree.CustamonagrRootInsert;

public final class CustamonVisiCustamonagrInsert extends ActionVisitorTemplateAction<CustamonInfo, CustamonagrInfo> {

	public CustamonVisiCustamonagrInsert(DeciTreeOption<CustamonInfo> option) {
		super(option, CustamonInfo.class, CustamonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustamonagrInfo>> getTreeClassHook() {
		return CustamonagrRootInsert.class;
	}
	
	
	
	@Override protected List<CustamonInfo> toBaseClassHook(List<CustamonInfo> baseInfos, List<CustamonagrInfo> results) {
		return CustamonMerger.mergeWithStedmonagr(baseInfos, results);
	}
}
