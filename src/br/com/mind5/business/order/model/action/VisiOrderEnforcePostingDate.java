package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderSetterPostingDate;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderEnforcePostingDate extends ActionVisitorTemplateEnforceV2<OrderInfo> {
	
	public VisiOrderEnforcePostingDate(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		InfoSetter<OrderInfo> setter = new OrderSetterPostingDate();
		return setter.setAttr(recordInfo);
	}
}
