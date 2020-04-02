package br.com.mind5.payment.statusPayOrderItem.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class StdPaytusemMergePayordem implements ActionStdV1<PaytusemInfo> {
	private ActionStdV1<PaytusemInfo> actionHelper;	
	
	
	public StdPaytusemMergePayordem(DeciTreeOption<PaytusemInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPaytusemMergePayordem(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PaytusemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaytusemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
