package br.com.mind5.payment.payOrderList.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class StdPayordistMergeToSelect implements ActionStd<PayordistInfo> {
	private ActionStd<PayordistInfo> actionHelper;	
	
	
	public StdPayordistMergeToSelect(DeciTreeOption<PayordistInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPayordistMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayordistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
