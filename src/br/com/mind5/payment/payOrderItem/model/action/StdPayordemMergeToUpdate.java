package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class StdPayordemMergeToUpdate implements ActionStdV1<PayordemInfo> {
	private ActionStdV1<PayordemInfo> actionHelper;	
	
	
	public StdPayordemMergeToUpdate(DeciTreeOption<PayordemInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPayordemMergeToUpdate(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PayordemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
