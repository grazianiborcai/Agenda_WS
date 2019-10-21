package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemSetterKey;

final class VisiPayordemEnforceKey extends ActionVisitorTemplateEnforce<PayordemInfo> {
	
	@Override protected PayordemInfo enforceHook(PayordemInfo recordInfo) {
		InfoSetter<PayordemInfo> setter = new PayordemSetterKey();
		return setter.setAttr(recordInfo);
	}
}
