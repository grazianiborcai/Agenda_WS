package br.com.gda.payment.ownerPartner.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;

public final class StdOwnparEnforceDefault implements ActionStd<OwnparInfo> {
	private ActionStd<OwnparInfo> actionHelper;	
	
	
	public StdOwnparEnforceDefault(DeciTreeOption<OwnparInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiOwnparEnforceDefault());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
