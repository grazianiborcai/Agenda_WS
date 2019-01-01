package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class StdPayCusDeletePhone implements ActionStd<PayCusInfo> {
	private ActionStd<PayCusInfo> actionHelper;	
	
	
	public StdPayCusDeletePhone(DeciTreeOption<PayCusInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiPayCusDeletePhone(option.conn, option.schemaName));
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
