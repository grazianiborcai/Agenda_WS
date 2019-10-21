package br.com.mind5.business.orderReserve.model.action;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.info.OrderverSetteCancelled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderveEnforceCancelled extends ActionVisitorTemplateEnforce<OrderveInfo> {
	
	@Override protected OrderveInfo enforceHook(OrderveInfo recordInfo) {
		InfoSetter<OrderveInfo> setter = new OrderverSetteCancelled();
		return setter.setAttr(recordInfo);
	}
}
