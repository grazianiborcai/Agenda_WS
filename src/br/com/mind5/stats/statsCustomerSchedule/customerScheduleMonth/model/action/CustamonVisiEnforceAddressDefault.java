package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonSetterAddressDefault;

public final class CustamonVisiEnforceAddressDefault extends ActionVisitorTemplateEnforce<CustamonInfo> {
	
	public CustamonVisiEnforceAddressDefault(DeciTreeOption<CustamonInfo> option) {
		super(option);
	}

	
	
	@Override protected CustamonInfo enforceHook(CustamonInfo recordInfo) {
		InfoSetter<CustamonInfo> attrSetter = new CustamonSetterAddressDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
