package br.com.mind5.payment.payOrderSearch.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class StdPayordarchMergeToSelect implements ActionStd<PayordarchInfo> {
	private ActionStd<PayordarchInfo> actionHelper;	
	
	
	public StdPayordarchMergeToSelect(DeciTreeOption<PayordarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPayordarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayordarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
