package br.com.mind5.payment.creditCardSearch.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class StdCrecarchMergeToSelect implements ActionStdV1<CrecarchInfo> {
	private ActionStdV1<CrecarchInfo> actionHelper;	
	
	
	public StdCrecarchMergeToSelect(DeciTreeOption<CrecarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCrecarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CrecarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CrecarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
