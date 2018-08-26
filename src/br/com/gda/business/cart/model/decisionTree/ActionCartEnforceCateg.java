package br.com.gda.business.cart.model.decisionTree;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionCartEnforceCateg implements DeciAction<CartInfo> {
	private DeciAction<CartInfo> actionHelper;	
	
	
	public ActionCartEnforceCateg(DeciTreeOption<CartInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorCartEnforceCateg());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<CartInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
