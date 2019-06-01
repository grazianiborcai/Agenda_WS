package br.com.gda.business.orderItem.model.action;

import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.business.orderItem.info.OrderSetterStatusCreated;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderEnforceStatusCreated extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> attrSetter = new OrderSetterStatusCreated();
		return attrSetter.setAttr(recordInfo);
	}
}
