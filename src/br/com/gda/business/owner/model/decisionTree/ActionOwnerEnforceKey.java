package br.com.gda.business.owner.model.decisionTree;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionOwnerEnforceKey implements DeciAction<OwnerInfo> {
	private DeciAction<OwnerInfo> actionHelper;	
	
	
	public ActionOwnerEnforceKey(DeciTreeOption<OwnerInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorOwnerEnforceKey());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<OwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
