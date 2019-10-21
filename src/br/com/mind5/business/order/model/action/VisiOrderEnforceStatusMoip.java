package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderSetterStatusMoip;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderEnforceStatusMoip extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterStatusMoip();
		return setter.setAttr(recordInfo);
	}
}
