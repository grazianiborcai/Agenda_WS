package br.com.mind5.business.orderItemCounter.model.action;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderItemCounter.info.OrdereouSetterItemCounter;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdereouEnforceItemCounter extends ActionVisitorTemplateEnforce<OrdereouInfo> {
	
	public VisiOrdereouEnforceItemCounter(DeciTreeOption<OrdereouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdereouInfo enforceHook(OrdereouInfo recordInfo) {
		InfoSetter<OrdereouInfo> setter = new OrdereouSetterItemCounter();
		return setter.setAttr(recordInfo);
	}
}
