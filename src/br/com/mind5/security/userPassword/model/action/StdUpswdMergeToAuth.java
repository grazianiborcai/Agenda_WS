package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdMergeToAuth implements ActionStdV1<UpswdInfo> {
	private ActionStdV1<UpswdInfo> actionHelper;	
	
	
	public StdUpswdMergeToAuth(DeciTreeOption<UpswdInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUpswdMergeToAuth(option.conn, option.schemaName));
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
