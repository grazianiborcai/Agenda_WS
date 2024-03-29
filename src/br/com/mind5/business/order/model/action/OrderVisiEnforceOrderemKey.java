package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderSetterOrderemKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiEnforceOrderemKey extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	public OrderVisiEnforceOrderemKey(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterOrderemKey();
		return setter.setAttr(recordInfo);
	}
}
