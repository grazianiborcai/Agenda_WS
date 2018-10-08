package br.com.gda.business.customer.model.decisionTree;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionCusEnforceEmail implements ActionStd<CusInfo> {
	private ActionStd<CusInfo> actionHelper;	
	
	
	public ActionCusEnforceEmail(DeciTreeOption<CusInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorCusEnforceEmail());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
