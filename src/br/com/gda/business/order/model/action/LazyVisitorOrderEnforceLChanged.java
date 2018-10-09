package br.com.gda.business.order.model.action;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderSetterLChanged;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class LazyVisitorOrderEnforceLChanged extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		OrderSetterLChanged attrSetter = new OrderSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
