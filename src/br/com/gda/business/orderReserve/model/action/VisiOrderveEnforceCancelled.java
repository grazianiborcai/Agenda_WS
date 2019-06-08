package br.com.gda.business.orderReserve.model.action;

import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.business.orderReserve.info.OrderverSetteCancelled;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderveEnforceCancelled extends ActionVisitorTemplateEnforce<OrderveInfo> {
	
	@Override protected OrderveInfo enforceHook(OrderveInfo recordInfo) {
		InfoSetter<OrderveInfo> setter = new OrderverSetteCancelled();
		return setter.setAttr(recordInfo);
	}
}
