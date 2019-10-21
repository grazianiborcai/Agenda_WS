package br.com.mind5.payment.creditCard.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class StdCrecardMergeCuspar implements ActionStd<CrecardInfo> {
	private ActionStd<CrecardInfo> actionHelper;	
	
	
	public StdCrecardMergeCuspar(DeciTreeOption<CrecardInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCrecardMergeCuspar(option.conn, option.schemaName));
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
