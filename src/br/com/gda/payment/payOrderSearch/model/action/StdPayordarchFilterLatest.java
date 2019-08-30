package br.com.gda.payment.payOrderSearch.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;

public final class StdPayordarchFilterLatest implements ActionStd<PayordarchInfo> {
	private ActionStd<PayordarchInfo> actionHelper;	
	
	
	public StdPayordarchFilterLatest(DeciTreeOption<PayordarchInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPayordarchFilterLatest());
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
