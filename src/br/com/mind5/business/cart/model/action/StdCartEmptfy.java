package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartEmptfy extends ActionStdTemplateV2<CartInfo>{

	public StdCartEmptfy(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CartInfo> buildVisitorHook(DeciTreeOption<CartInfo> option) {
		return new VisiCartEmptfy(option);
	}
}