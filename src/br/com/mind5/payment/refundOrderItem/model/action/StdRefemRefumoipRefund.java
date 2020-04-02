package br.com.mind5.payment.refundOrderItem.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class StdRefemRefumoipRefund implements ActionStdV1<RefemInfo> {
	private ActionStdV1<RefemInfo> actionHelper;	
	
	
	public StdRefemRefumoipRefund(DeciTreeOption<RefemInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiRefemRefumoipRefund(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<RefemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<RefemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
