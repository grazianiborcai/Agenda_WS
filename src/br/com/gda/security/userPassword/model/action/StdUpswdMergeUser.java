package br.com.gda.security.userPassword.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class StdUpswdMergeUser implements ActionStd<UpswdInfo> {
	private ActionStd<UpswdInfo> actionHelper;	
	
	
	public StdUpswdMergeUser(DeciTreeOption<UpswdInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUpswdMergeUser(option.conn, option.schemaName));
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
