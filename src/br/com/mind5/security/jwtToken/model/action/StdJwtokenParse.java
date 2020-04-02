package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class StdJwtokenParse implements ActionStdV1<JwtokenInfo> {
	private ActionStdV1<JwtokenInfo> actionHelper;	
	
	
	public StdJwtokenParse(DeciTreeOption<JwtokenInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiJwtokenParse());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<JwtokenInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<JwtokenInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
