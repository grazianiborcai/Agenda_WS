package br.com.mind5.payment.payOrderItemList.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class StdPayordemistMergePayormarch implements ActionStdV1<PayordemistInfo> {
	private ActionStdV1<PayordemistInfo> actionHelper;	
	
	
	public StdPayordemistMergePayormarch(DeciTreeOption<PayordemistInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPayordemistMergePayormarch(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PayordemistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordemistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
