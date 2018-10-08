package br.com.gda.business.order.model.action;

import br.com.gda.business.order.info.OrderSetterExtid;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.business.order.info.OrderInfo;

final class VisitorOrderEnforceExtid extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		OrderSetterExtid idMaker = new OrderSetterExtid();
		return idMaker.setAttr(recordInfo);
	}
}
