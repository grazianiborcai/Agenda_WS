package br.com.mind5.payment.payOrderSearch.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

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
