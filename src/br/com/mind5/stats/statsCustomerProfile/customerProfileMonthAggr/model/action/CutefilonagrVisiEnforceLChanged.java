package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrSetterLChanged;

public final class CutefilonagrVisiEnforceLChanged extends ActionVisitorTemplateEnforce<CutefilonagrInfo> {
	
	public CutefilonagrVisiEnforceLChanged(DeciTreeOption<CutefilonagrInfo> option) {
		super(option);
	}

	
	
	@Override protected CutefilonagrInfo enforceHook(CutefilonagrInfo recordInfo) {
		InfoSetter<CutefilonagrInfo> attrSetter = new CutefilonagrSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
