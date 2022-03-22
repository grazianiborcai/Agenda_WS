package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonMerger;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.decisionTree.CustamonagrRootUpsert;

public final class CustamonVisiCustamonagrUpsert extends ActionVisitorTemplateAction<CustamonInfo, CustamonagrInfo> {

	public CustamonVisiCustamonagrUpsert(DeciTreeOption<CustamonInfo> option) {
		super(option, CustamonInfo.class, CustamonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustamonagrInfo>> getTreeClassHook() {
		return CustamonagrRootUpsert.class;
	}
	
	
	
	@Override protected List<CustamonInfo> toBaseClassHook(List<CustamonInfo> baseInfos, List<CustamonagrInfo> results) {
		return CustamonMerger.mergeWithStedmonagr(baseInfos, results);
	}
}
