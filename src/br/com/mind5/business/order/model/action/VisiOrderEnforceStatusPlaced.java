package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderSetterStatusPlaced;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderEnforceStatusPlaced extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterStatusPlaced();
		return setter.setAttr(recordInfo);
	}
}
