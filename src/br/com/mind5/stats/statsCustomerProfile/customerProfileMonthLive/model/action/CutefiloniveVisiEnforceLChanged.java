package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveSetterLChanged;

public final class CutefiloniveVisiEnforceLChanged extends ActionVisitorTemplateEnforce<CutefiloniveInfo> {
	
	public CutefiloniveVisiEnforceLChanged(DeciTreeOption<CutefiloniveInfo> option) {
		super(option);
	}

	
	
	@Override protected CutefiloniveInfo enforceHook(CutefiloniveInfo recordInfo) {
		InfoSetter<CutefiloniveInfo> attrSetter = new CutefiloniveSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
