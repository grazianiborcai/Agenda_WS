package br.com.gda.business.material.model.decisionTree;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatEnforceKey implements DeciAction<MatInfo> {
	private DeciAction<MatInfo> actionHelper;	
	
	
	public ActionMatEnforceKey(DeciTreeOption<MatInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorMatEnforceKey());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
