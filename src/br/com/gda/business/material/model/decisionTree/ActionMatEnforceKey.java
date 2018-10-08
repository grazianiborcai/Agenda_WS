package br.com.gda.business.material.model.decisionTree;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatEnforceKey implements ActionStd<MatInfo> {
	private ActionStd<MatInfo> actionHelper;	
	
	
	public ActionMatEnforceKey(DeciTreeOption<MatInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorMatEnforceKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
