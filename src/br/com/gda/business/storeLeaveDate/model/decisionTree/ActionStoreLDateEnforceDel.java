package br.com.gda.business.storeLeaveDate.model.decisionTree;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreLDateEnforceDel implements ActionStd<StoreLDateInfo> {
	private ActionStd<StoreLDateInfo> actionHelper;	
	
	
	public ActionStoreLDateEnforceDel(DeciTreeOption<StoreLDateInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorStoreLDateEnforceDel());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoreLDateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreLDateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
