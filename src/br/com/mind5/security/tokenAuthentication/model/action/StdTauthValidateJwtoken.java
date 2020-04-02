package br.com.mind5.security.tokenAuthentication.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;

public final class StdTauthValidateJwtoken implements ActionStdV1<TauthInfo> {
	private ActionStdV1<TauthInfo> actionHelper;	
	
	
	public StdTauthValidateJwtoken(DeciTreeOption<TauthInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiTauthValidateJwtoken(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<TauthInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<TauthInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
