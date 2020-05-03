package br.com.mind5.business.orderItem.model.action;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemEnforceWeekday extends ActionVisitorTemplateEnforceV2<OrderemInfo> {
	
	public VisiOrderemEnforceWeekday(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrderemInfo enforceHook(OrderemInfo recordInfo) {
		InfoSetter<OrderemInfo> setter = new OrderemSetterWeekday();
		return setter.setAttr(recordInfo);
	}
}
