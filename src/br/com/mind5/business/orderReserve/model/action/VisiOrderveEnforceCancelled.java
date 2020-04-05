package br.com.mind5.business.orderReserve.model.action;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.info.OrderverSetteCancelled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiOrderveEnforceCancelled extends ActionVisitorTemplateEnforceV1<OrderveInfo> {
	
	@Override protected OrderveInfo enforceHook(OrderveInfo recordInfo) {
		InfoSetter<OrderveInfo> setter = new OrderverSetteCancelled();
		return setter.setAttr(recordInfo);
	}
}
