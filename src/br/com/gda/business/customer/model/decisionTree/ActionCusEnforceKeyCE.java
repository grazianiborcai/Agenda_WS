package br.com.gda.business.customer.model.decisionTree;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionCusEnforceKeyCE implements DeciAction<CusInfo> {
	private DeciAction<CusInfo> actionHelper;	
	
	
	public ActionCusEnforceKeyCE(DeciTreeOption<CusInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorCusEnforceKeyCE());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<CusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
