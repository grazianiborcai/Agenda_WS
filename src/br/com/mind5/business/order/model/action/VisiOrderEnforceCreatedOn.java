package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderEnforceCreatedOn extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	public VisiOrderEnforceCreatedOn(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterCreatedOn();
		return setter.setAttr(recordInfo);
	}
}
