package br.com.mind5.payment.creditCard.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class StdCrecardMergeAddress implements ActionStdV1<CrecardInfo> {
	private ActionStdV1<CrecardInfo> actionHelper;	
	
	
	public StdCrecardMergeAddress(DeciTreeOption<CrecardInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCrecardMergeAddress(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CrecardInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CrecardInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
