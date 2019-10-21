package br.com.mind5.payment.creditCard.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class StdCrecardInsertCuspar implements ActionStd<CrecardInfo> {
	private ActionStd<CrecardInfo> actionHelper;	
	
	
	public StdCrecardInsertCuspar(DeciTreeOption<CrecardInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiCrecardInsertCuspar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CrecardInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CrecardInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
