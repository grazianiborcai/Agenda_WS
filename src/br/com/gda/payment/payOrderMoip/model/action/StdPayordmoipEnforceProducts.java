package br.com.gda.payment.payOrderMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderMoip.info.PayordmoipInfo;

public final class StdPayordmoipEnforceProducts implements ActionStd<PayordmoipInfo> {
	private ActionStd<PayordmoipInfo> actionHelper;	
	
	
	public StdPayordmoipEnforceProducts(DeciTreeOption<PayordmoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPayordmoipEnforceProducts());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayordmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
