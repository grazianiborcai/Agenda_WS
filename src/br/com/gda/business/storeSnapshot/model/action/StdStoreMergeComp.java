package br.com.gda.business.storeSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdStoreMergeComp implements ActionStd<StorapInfo> {
	private ActionStd<StorapInfo> actionHelper;	
	
	
	public StdStoreMergeComp(DeciTreeOption<StorapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStoreMergeComp(option.conn, option.schemaName));
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
