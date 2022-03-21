package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveSetterLChanged;

public final class CustamoniveVisiEnforceLChanged extends ActionVisitorTemplateEnforce<CustamoniveInfo> {
	
	public CustamoniveVisiEnforceLChanged(DeciTreeOption<CustamoniveInfo> option) {
		super(option);
	}

	
	
	@Override protected CustamoniveInfo enforceHook(CustamoniveInfo recordInfo) {
		InfoSetter<CustamoniveInfo> attrSetter = new CustamoniveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
