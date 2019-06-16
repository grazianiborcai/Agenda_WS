package br.com.gda.payment.customer.model.action;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.payment.customer.info.PaycusSetterKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPaycusEnforceKey extends ActionVisitorTemplateEnforce<PaycusInfo> {
	
	@Override protected PaycusInfo enforceHook(PaycusInfo recordInfo) {
		InfoSetter<PaycusInfo> setter = new PaycusSetterKey();
		return setter.setAttr(recordInfo);
	}
}
