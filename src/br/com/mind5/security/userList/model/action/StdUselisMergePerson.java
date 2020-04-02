package br.com.mind5.security.userList.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;

final class StdUselisMergePerson implements ActionStdV1<UselisInfo> {
	private ActionStdV1<UselisInfo> actionHelper;	
	
	
	public StdUselisMergePerson(DeciTreeOption<UselisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUselisMergePersolis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<UselisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UselisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
