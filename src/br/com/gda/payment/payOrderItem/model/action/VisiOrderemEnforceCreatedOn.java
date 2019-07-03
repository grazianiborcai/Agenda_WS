package br.com.gda.payment.payOrderItem.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.payOrderItem.info.OrderemSetterCreatedOn;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class VisiOrderemEnforceCreatedOn extends ActionVisitorTemplateEnforce<PayordemInfo> {
	
	@Override protected PayordemInfo enforceHook(PayordemInfo recordInfo) {
		InfoSetter<PayordemInfo> setter = new OrderemSetterCreatedOn();
		return setter.setAttr(recordInfo);
	}
}
