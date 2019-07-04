package br.com.gda.payment.payOrderItem.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.payOrderItem.info.PayordemSetterKey;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class VisiPayordemEnforceKey extends ActionVisitorTemplateEnforce<PayordemInfo> {
	
	@Override protected PayordemInfo enforceHook(PayordemInfo recordInfo) {
		InfoSetter<PayordemInfo> setter = new PayordemSetterKey();
		return setter.setAttr(recordInfo);
	}
}
