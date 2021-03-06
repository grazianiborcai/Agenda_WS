package br.com.mind5.business.orderReserve.model.action;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderveDaoSelect extends ActionStdTemplate<OrderveInfo> {

	public StdOrderveDaoSelect(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrderveInfo> buildVisitorHook(DeciTreeOption<OrderveInfo> option) {
		return new VisiOrderveDaoSelect(option);
	}
}
