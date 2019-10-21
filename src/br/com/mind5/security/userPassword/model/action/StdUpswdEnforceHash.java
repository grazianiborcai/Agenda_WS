package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdEnforceHash implements ActionStd<UpswdInfo> {
	private ActionStd<UpswdInfo> actionHelper;	
	
	
	public StdUpswdEnforceHash(DeciTreeOption<UpswdInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiUpswdEnforceHash());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UpswdInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UpswdInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
