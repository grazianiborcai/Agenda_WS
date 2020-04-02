package br.com.mind5.security.user.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

public final class StdUserMergeToUpdate implements ActionStdV1<UserInfo> {
	private ActionStdV1<UserInfo> actionHelper;	
	
	
	public StdUserMergeToUpdate(DeciTreeOption<UserInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUserMergeToUpdate(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<UserInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
