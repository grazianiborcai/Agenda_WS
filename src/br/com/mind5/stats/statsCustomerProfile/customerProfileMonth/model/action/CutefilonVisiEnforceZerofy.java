package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonSetterZerofy;

public final class CutefilonVisiEnforceZerofy extends ActionVisitorTemplateEnforce<CutefilonInfo> {
	
	public CutefilonVisiEnforceZerofy(DeciTreeOption<CutefilonInfo> option) {
		super(option);
	}

	
	
	@Override protected CutefilonInfo enforceHook(CutefilonInfo recordInfo) {
		InfoSetter<CutefilonInfo> attrSetter = new CutefilonSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
