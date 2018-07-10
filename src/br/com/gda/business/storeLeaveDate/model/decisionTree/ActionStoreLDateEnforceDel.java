package br.com.gda.business.storeLeaveDate.model.decisionTree;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreLDateEnforceDel implements DeciAction<StoreLDateInfo> {
	private DeciAction<StoreLDateInfo> actionHelper;	
	
	
	public ActionStoreLDateEnforceDel(DeciTreeOption<StoreLDateInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorStoreLDateEnforceDel());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreLDateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreLDateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
