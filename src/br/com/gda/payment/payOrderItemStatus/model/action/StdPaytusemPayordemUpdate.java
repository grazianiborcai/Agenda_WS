package br.com.gda.payment.payOrderItemStatus.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderItemStatus.info.PaytusemInfo;

public final class StdPaytusemPayordemUpdate implements ActionStd<PaytusemInfo> {
	private ActionStd<PaytusemInfo> actionHelper;	
	
	
	public StdPaytusemPayordemUpdate(DeciTreeOption<PaytusemInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPaytusemPayordemUpdate(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaytusemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaytusemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
