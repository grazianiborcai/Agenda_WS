package br.com.gda.business.order.model.action;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderSetterStatusCreated;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderEnforceStatusCreated extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterStatusCreated();
		return setter.setAttr(recordInfo);
	}
}
