package br.com.mind5.business.orderItemCounter.model.action;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderItemCounter.info.OrdereouSetterOrdemist;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdereouVisiObfuscateOrdemist extends ActionVisitorTemplateEnforce<OrdereouInfo> {
	
	public OrdereouVisiObfuscateOrdemist(DeciTreeOption<OrdereouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdereouInfo enforceHook(OrdereouInfo recordInfo) {
		InfoSetter<OrdereouInfo> setter = new OrdereouSetterOrdemist();
		return setter.setAttr(recordInfo);
	}
}
