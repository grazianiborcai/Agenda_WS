package br.com.gda.business.cartSnapshot_.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCartSnapEnforceKey implements ActionStd<CartSnapInfo> {
	private ActionStd<CartSnapInfo> actionHelper;	
	
	
	public StdCartSnapEnforceKey(DeciTreeOption<CartSnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCartSnapEnforceKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
