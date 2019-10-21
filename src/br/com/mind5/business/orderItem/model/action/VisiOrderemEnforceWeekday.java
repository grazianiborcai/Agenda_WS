package br.com.mind5.business.orderItem.model.action;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderemEnforceWeekday extends ActionVisitorTemplateEnforce<OrderemInfo> {
	
	@Override protected OrderemInfo enforceHook(OrderemInfo recordInfo) {
		InfoSetter<OrderemInfo> setter = new OrderemSetterWeekday();
		return setter.setAttr(recordInfo);
	}
}
