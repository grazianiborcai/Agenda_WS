package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class StdPayordemMergeMatlis implements ActionStd<PayordemInfo> {
	private ActionStd<PayordemInfo> actionHelper;	
	
	
	public StdPayordemMergeMatlis(DeciTreeOption<PayordemInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPayordemMergeMatlis(option.conn, option.schemaName));
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