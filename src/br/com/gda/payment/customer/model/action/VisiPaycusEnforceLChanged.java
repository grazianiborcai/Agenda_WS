package br.com.gda.payment.customer.model.action;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.payment.customer.info.PaycusSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPaycusEnforceLChanged extends ActionVisitorTemplateEnforce<PaycusInfo> {
	
	@Override protected PaycusInfo enforceHook(PaycusInfo recordInfo) {
		InfoSetter<PaycusInfo> setter = new PaycusSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
