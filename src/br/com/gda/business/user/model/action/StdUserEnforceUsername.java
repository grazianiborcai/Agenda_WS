package br.com.gda.business.user.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdUserEnforceUsername implements ActionStd<UserInfo> {
	private ActionStd<UserInfo> actionHelper;	
	
	
	public StdUserEnforceUsername(DeciTreeOption<UserInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiUserEnforceUsername());
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
