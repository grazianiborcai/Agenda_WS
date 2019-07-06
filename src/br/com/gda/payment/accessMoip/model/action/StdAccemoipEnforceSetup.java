package br.com.gda.payment.accessMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.accessMoip.info.AccemoipInfo;

public final class StdAccemoipEnforceSetup implements ActionStd<AccemoipInfo> {
	private ActionStd<AccemoipInfo> actionHelper;	
	
	
	public StdAccemoipEnforceSetup(DeciTreeOption<AccemoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiAccemoipEnforceSetup());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AccemoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AccemoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
