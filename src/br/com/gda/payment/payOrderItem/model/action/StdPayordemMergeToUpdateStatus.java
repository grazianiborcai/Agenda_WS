package br.com.gda.payment.payOrderItem.model.action;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class StdPayordemMergeToUpdateStatus implements ActionStd<PayordemInfo> {
	private ActionStd<PayordemInfo> actionHelper;	
	
	
	public StdPayordemMergeToUpdateStatus(DeciTreeOption<PayordemInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPayordemMergeToUpdateStatus(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayordemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
