package br.com.gda.business.cart.model.action;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCartEnforceItemtotal implements ActionStd<CartInfo> {
	private ActionStd<CartInfo> actionHelper;	
	
	
	public StdCartEnforceItemtotal(DeciTreeOption<CartInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCartEnforceItemtotal());
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
