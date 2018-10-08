package br.com.gda.business.cart.model.decisionTree;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionCartEnforceItemNum implements ActionStd<CartInfo> {
	private ActionStd<CartInfo> actionHelper;	
	
	
	public ActionCartEnforceItemNum(DeciTreeOption<CartInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorCartEnforceItemNum(option.conn, option.schemaName));
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
