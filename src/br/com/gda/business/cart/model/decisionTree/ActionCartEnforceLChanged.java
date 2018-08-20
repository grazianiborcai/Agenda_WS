package br.com.gda.business.cart.model.decisionTree;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionCartEnforceLChanged implements DeciAction<CartInfo> {
	private DeciAction<CartInfo> actionHelper;	
	
	
	public ActionCartEnforceLChanged(DeciTreeOption<CartInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorCartEnforceLChanged());
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
