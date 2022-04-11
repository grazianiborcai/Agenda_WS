package br.com.mind5.business.orderReserve.model.action;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.info.OrderverSetteCancelled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderveVisiEnforceCancelled extends ActionVisitorTemplateEnforce<OrderveInfo> {
	
	public OrderveVisiEnforceCancelled(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrderveInfo enforceHook(OrderveInfo recordInfo) {
		InfoSetter<OrderveInfo> setter = new OrderverSetteCancelled();
		return setter.setAttr(recordInfo);
	}
}
