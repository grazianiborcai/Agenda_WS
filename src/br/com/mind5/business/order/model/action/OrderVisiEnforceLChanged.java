package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiEnforceLChanged extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	public OrderVisiEnforceLChanged(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
