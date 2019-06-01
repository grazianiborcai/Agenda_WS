package br.com.gda.business.orderItem.model.action;

import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.business.orderItem.info.OrderSetterExtid;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderEnforceExtid extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		OrderSetterExtid idMaker = new OrderSetterExtid();
		return idMaker.setAttr(recordInfo);
	}
}
