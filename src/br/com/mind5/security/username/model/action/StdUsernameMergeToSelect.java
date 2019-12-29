package br.com.mind5.security.username.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StdUsernameMergeToSelect implements ActionStd<UsernameInfo> {
	private ActionStd<UsernameInfo> actionHelper;	
	
	
	public StdUsernameMergeToSelect(DeciTreeOption<UsernameInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUsernameMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UsernameInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UsernameInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
