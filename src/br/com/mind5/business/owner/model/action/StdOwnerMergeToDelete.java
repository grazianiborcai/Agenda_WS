package br.com.mind5.business.owner.model.action;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerMergeToDelete implements ActionStd<OwnerInfo> {
	private ActionStd<OwnerInfo> actionHelper;	
	
	
	public StdOwnerMergeToDelete(DeciTreeOption<OwnerInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOwnerMergeToDelete(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
