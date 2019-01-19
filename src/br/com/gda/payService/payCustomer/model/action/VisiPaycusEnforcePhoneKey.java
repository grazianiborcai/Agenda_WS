package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.info.PaycusSetterPhoneKey;

final class VisiPaycusEnforcePhoneKey extends ActionVisitorTemplateEnforce<PaycusInfo> {
	
	@Override protected PaycusInfo enforceHook(PaycusInfo recordInfo) {
		InfoSetter<PaycusInfo> attrSetter = new PaycusSetterPhoneKey();
		return attrSetter.setAttr(recordInfo);
	}
}
