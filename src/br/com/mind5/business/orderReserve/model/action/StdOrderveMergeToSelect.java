package br.com.mind5.business.orderReserve.model.action;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderveMergeToSelect extends ActionStdTemplate<OrderveInfo> {

	public StdOrderveMergeToSelect(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrderveInfo> buildVisitorHook(DeciTreeOption<OrderveInfo> option) {
		return new VisiOrderveMergeToSelect(option);
	}
}
