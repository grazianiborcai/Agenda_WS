package br.com.mind5.business.orderItemCounter.model.action;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdereouMergeOrdemarch extends ActionStdTemplate<OrdereouInfo> {

	public StdOrdereouMergeOrdemarch(DeciTreeOption<OrdereouInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdereouInfo> buildVisitorHook(DeciTreeOption<OrdereouInfo> option) {
		return new VisiOrdereouMergeOrdemarch(option);
	}
}
