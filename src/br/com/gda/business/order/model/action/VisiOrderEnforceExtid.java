package br.com.gda.business.order.model.action;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderSetterExtid;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderEnforceExtid extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterExtid();
		return setter.setAttr(recordInfo);
	}
}
