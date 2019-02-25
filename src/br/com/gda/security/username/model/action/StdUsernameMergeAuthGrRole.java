package br.com.gda.security.username.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.username.info.UsernameInfo;

public final class StdUsernameMergeAuthGrRole implements ActionStd<UsernameInfo> {
	private ActionStd<UsernameInfo> actionHelper;	
	
	
	public StdUsernameMergeAuthGrRole(DeciTreeOption<UsernameInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiUsernameMergeAuthGrRole(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UsernameInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UsernameInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
