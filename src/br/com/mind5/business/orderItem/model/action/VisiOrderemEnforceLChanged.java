package br.com.mind5.business.orderItem.model.action;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemEnforceLChanged extends ActionVisitorTemplateEnforce<OrderemInfo> {
	
	public VisiOrderemEnforceLChanged(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrderemInfo enforceHook(OrderemInfo recordInfo) {
		InfoSetter<OrderemInfo> setter = new OrderemSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
