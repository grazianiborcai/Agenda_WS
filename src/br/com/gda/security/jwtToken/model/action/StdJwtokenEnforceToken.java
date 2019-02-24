package br.com.gda.security.jwtToken.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.jwtToken.info.JwtokenInfo;

public final class StdJwtokenEnforceToken implements ActionStd<JwtokenInfo> {
	private ActionStd<JwtokenInfo> actionHelper;	
	
	
	public StdJwtokenEnforceToken(DeciTreeOption<JwtokenInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiJwtokenEnforceToken());
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
