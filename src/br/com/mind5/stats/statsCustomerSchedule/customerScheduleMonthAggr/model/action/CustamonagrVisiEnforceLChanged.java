package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrSetterLChanged;

public final class CustamonagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<CustamonagrInfo> {
	
	public CustamonagrVisiEnforceLChanged(DeciTreeOption<CustamonagrInfo> option) {
		super(option);
	}

	
	
	@Override protected CustamonagrInfo enforceHook(CustamonagrInfo recordInfo) {
		InfoSetter<CustamonagrInfo> attrSetter = new CustamonagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
