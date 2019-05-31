package br.com.gda.business.cart.model.action;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCartMergeFeedef implements ActionStd<CartInfo> {
	private ActionStd<CartInfo> actionHelper;	
	
	
	public StdCartMergeFeedef(DeciTreeOption<CartInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCartMergeFeedef(option.conn, option.schemaName));
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
