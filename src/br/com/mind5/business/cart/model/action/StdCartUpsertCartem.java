package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartUpsertCartem implements ActionStdV1<CartInfo> {
	private ActionStdV1<CartInfo> actionHelper;	
	
	
	public StdCartUpsertCartem(DeciTreeOption<CartInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiCartUpsertCartem(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CartInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
