package br.com.gda.business.userSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdUserapMergePersonap implements ActionStd<UserapInfo> {
	private ActionStd<UserapInfo> actionHelper;	
	
	
	public StdUserapMergePersonap(DeciTreeOption<UserapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUserapMergePersonap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
