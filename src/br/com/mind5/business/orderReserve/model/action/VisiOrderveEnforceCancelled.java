package br.com.mind5.business.orderReserve.model.action;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.info.OrderverSetteCancelled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderveEnforceCancelled extends ActionVisitorTemplateEnforceV2<OrderveInfo> {
	
	public VisiOrderveEnforceCancelled(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrderveInfo enforceHook(OrderveInfo recordInfo) {
		InfoSetter<OrderveInfo> setter = new OrderverSetteCancelled();
		return setter.setAttr(recordInfo);
	}
}
