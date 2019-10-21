package br.com.mind5.business.cart.model.action;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartEnforceGrantotal implements ActionStd<CartInfo> {
	private ActionStd<CartInfo> actionHelper;	
	
	
	public StdCartEnforceGrantotal(DeciTreeOption<CartInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCartEnforceGrantotal());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
