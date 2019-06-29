package br.com.gda.payment.creditCard.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCrecardMergePhone implements ActionStd<CrecardInfo> {
	private ActionStd<CrecardInfo> actionHelper;	
	
	
	public StdCrecardMergePhone(DeciTreeOption<CrecardInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCrecardMergePhone(option.conn, option.schemaName));
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
