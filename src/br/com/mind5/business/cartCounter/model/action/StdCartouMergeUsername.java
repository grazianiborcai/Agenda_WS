package br.com.mind5.business.cartCounter.model.action;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartouMergeUsername extends ActionStdTemplate<CartouInfo> {

	public StdCartouMergeUsername(DeciTreeOption<CartouInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CartouInfo> buildVisitorHook(DeciTreeOption<CartouInfo> option) {
		return new VisiCartouMergeUsername(option);
	}
}
