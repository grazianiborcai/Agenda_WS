package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderMergeFeecat extends ActionStdTemplate<OrderInfo> {

	public StdOrderMergeFeecat(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrderInfo> buildVisitorHook(DeciTreeOption<OrderInfo> option) {
		return new VisiOrderMergeFeecat(option);
	}
}
