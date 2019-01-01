package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class StdPayCusEnforcePhoneKey implements ActionStd<PayCusInfo> {
	private ActionStd<PayCusInfo> actionHelper;	
	
	
	public StdPayCusEnforcePhoneKey(DeciTreeOption<PayCusInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPayCusEnforcePhoneKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayCusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayCusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
