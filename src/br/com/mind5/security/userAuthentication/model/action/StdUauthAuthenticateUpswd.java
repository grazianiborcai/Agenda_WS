package br.com.mind5.security.userAuthentication.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class StdUauthAuthenticateUpswd implements ActionStd<UauthInfo> {
	private ActionStd<UauthInfo> actionHelper;	
	
	
	public StdUauthAuthenticateUpswd(DeciTreeOption<UauthInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiUauthAuthenticateUpswd(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UauthInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UauthInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
