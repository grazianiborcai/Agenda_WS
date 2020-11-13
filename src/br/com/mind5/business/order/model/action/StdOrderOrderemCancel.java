package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderOrderemCancel extends ActionStdTemplate<OrderInfo> {

	public StdOrderOrderemCancel(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrderInfo> buildVisitorHook(DeciTreeOption<OrderInfo> option) {
		return new VisiOrderOrderemCancel(option);
	}
}
