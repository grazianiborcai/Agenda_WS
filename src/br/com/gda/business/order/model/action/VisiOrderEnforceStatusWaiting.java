package br.com.gda.business.order.model.action;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderSetterStatusWaiting;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderEnforceStatusWaiting extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterStatusWaiting();
		return setter.setAttr(recordInfo);
	}
}
