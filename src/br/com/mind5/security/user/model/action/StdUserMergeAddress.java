package br.com.mind5.security.user.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

public final class StdUserMergeAddress implements ActionStd<UserInfo> {
	private ActionStd<UserInfo> actionHelper;	
	
	
	public StdUserMergeAddress(DeciTreeOption<UserInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUserMergeAddress(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
