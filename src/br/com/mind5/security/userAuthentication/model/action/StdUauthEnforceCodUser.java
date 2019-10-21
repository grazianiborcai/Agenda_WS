package br.com.mind5.security.userAuthentication.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class StdUauthEnforceCodUser implements ActionStd<UauthInfo> {
	private ActionStd<UauthInfo> actionHelper;	
	
	
	public StdUauthEnforceCodUser(DeciTreeOption<UauthInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiUauthEnforceCodUser());
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
