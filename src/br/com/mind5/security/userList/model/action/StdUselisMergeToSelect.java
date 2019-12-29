package br.com.mind5.security.userList.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;

public final class StdUselisMergeToSelect implements ActionStd<UselisInfo> {
	private ActionStd<UselisInfo> actionHelper;	
	
	
	public StdUselisMergeToSelect(DeciTreeOption<UselisInfo> option) {			
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
