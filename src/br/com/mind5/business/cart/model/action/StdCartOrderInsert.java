package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartOrderInsert extends ActionStdTemplate<CartInfo> {

	public StdCartOrderInsert(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CartInfo> buildVisitorHook(DeciTreeOption<CartInfo> option) {
		return new VisiCartOrderInsert(option);
	}
}
