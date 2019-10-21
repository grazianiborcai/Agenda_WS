package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class StdJwtokenEnforceSecret implements ActionStd<JwtokenInfo> {
	private ActionStd<JwtokenInfo> actionHelper;	
	
	
	public StdJwtokenEnforceSecret(DeciTreeOption<JwtokenInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiJwtokenEnforceSecret());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<JwtokenInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<JwtokenInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
