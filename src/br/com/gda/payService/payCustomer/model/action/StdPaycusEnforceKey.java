package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class StdPaycusEnforceKey implements ActionStd<PaycusInfo> {
	private ActionStd<PaycusInfo> actionHelper;	
	
	
	public StdPaycusEnforceKey(DeciTreeOption<PaycusInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPaycusEnforceKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaycusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaycusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
