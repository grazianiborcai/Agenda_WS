package br.com.gda.payment.payOrder.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class StdPayordMergeToDelete implements ActionStd<PayordInfo> {
	private ActionStd<PayordInfo> actionHelper;	
	
	
	public StdPayordMergeToDelete(DeciTreeOption<PayordInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPayordMergeToDelete(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayordInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
