package br.com.gda.business.orderItem.model.action;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.info.OrderemSetterKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderemEnforceKey extends ActionVisitorTemplateEnforce<OrderemInfo> {
	
	@Override protected OrderemInfo enforceHook(OrderemInfo recordInfo) {
		InfoSetter<OrderemInfo> setter = new OrderemSetterKey();
		return setter.setAttr(recordInfo);
	}
}
