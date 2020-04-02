package br.com.mind5.payment.payOrderItemSearch.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class StdPayormarchMergeToSelect implements ActionStdV1<PayormarchInfo> {
	private ActionStdV1<PayormarchInfo> actionHelper;	
	
	
	public StdPayormarchMergeToSelect(DeciTreeOption<PayormarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPayormarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PayormarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayormarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
