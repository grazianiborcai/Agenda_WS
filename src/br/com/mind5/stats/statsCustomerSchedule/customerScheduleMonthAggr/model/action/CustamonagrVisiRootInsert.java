package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.decisionTree.CustamonagrRootInsert;

public final class CustamonagrVisiRootInsert extends ActionVisitorTemplateAction<CustamonagrInfo, CustamonagrInfo> {

	public CustamonagrVisiRootInsert(DeciTreeOption<CustamonagrInfo> option) {
		super(option, CustamonagrInfo.class, CustamonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustamonagrInfo>> getTreeClassHook() {
		return CustamonagrRootInsert.class;
	}
	
	
	
	@Override protected List<CustamonagrInfo> toBaseClassHook(List<CustamonagrInfo> baseInfos, List<CustamonagrInfo> results) {
		return results;
	}
}
