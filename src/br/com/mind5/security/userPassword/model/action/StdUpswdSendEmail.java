package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdSendEmail implements ActionStdV1<UpswdInfo> {
	private ActionStdV1<UpswdInfo> actionHelper;	
	
	
	public StdUpswdSendEmail(DeciTreeOption<UpswdInfo> option) {			
		actionHelper = new ActionStdHelperAction<UpswdInfo>(option.recordInfos, new VisiUpswdSendEmail(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<UpswdInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UpswdInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
