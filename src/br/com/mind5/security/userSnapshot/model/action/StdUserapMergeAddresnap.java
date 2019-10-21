package br.com.mind5.security.userSnapshot.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class StdUserapMergeAddresnap implements ActionStd<UserapInfo> {
	private ActionStd<UserapInfo> actionHelper;	
	
	
	public StdUserapMergeAddresnap(DeciTreeOption<UserapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUserapMergeAddresnap(option.conn, option.schemaName));
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
