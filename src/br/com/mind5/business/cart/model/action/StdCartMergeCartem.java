package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartMergeCartem extends ActionStdTemplate<CartInfo> {

	public StdCartMergeCartem(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CartInfo> buildVisitorHook(DeciTreeOption<CartInfo> option) {
		return new VisiCartMergeCartem(option);
	}
}
