package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderEnforceCreatedBy extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterCreatedBy();
		return setter.setAttr(recordInfo);
	}
}
