package br.com.gda.payment.customer.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPaycusMergeToSelect implements ActionStd<PaycusInfo> {
	private ActionStd<PaycusInfo> actionHelper;	
	
	
	public StdPaycusMergeToSelect(DeciTreeOption<PaycusInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPaycusMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaycusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaycusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
