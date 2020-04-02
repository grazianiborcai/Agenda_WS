package br.com.mind5.security.userSnapshot.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class StdUserapMergePersonap implements ActionStdV1<UserapInfo> {
	private ActionStdV1<UserapInfo> actionHelper;	
	
	
	public StdUserapMergePersonap(DeciTreeOption<UserapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUserapMergePersonap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<UserapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
