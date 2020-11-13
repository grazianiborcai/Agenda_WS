package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartemEnforceCreatedOn extends ActionStdTemplate<CartemInfo> {

	public StdCartemEnforceCreatedOn(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CartemInfo> buildVisitorHook(DeciTreeOption<CartemInfo> option) {
		return new VisiCartemEnforceCreatedOn(option);
	}
}
