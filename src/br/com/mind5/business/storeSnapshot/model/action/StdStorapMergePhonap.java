package br.com.mind5.business.storeSnapshot.model.action;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorapMergePhonap implements ActionStd<StorapInfo> {
	private ActionStd<StorapInfo> actionHelper;	
	
	
	public StdStorapMergePhonap(DeciTreeOption<StorapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStorapMergePhonap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StorapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
