package br.com.gda.security.userList.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userList.info.UselisInfo;

public final class StdUserMergeToSelect implements ActionStd<UselisInfo> {
	private ActionStd<UselisInfo> actionHelper;	
	
	
	public StdUserMergeToSelect(DeciTreeOption<UselisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUselisMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UselisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UselisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
