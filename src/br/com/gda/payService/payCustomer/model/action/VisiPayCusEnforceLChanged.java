package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.info.PayCusSetterLChanged;

final class VisiPayCusEnforceLChanged extends ActionVisitorTemplateEnforce<PayCusInfo> {
	
	@Override protected PayCusInfo enforceHook(PayCusInfo recordInfo) {
		InfoSetter<PayCusInfo> attrSetter = new PayCusSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
