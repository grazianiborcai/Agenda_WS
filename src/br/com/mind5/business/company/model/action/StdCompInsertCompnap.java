package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompInsertCompnap implements ActionStd<CompInfo> {
	private ActionStd<CompInfo> actionHelper;	
	
	
	public StdCompInsertCompnap(DeciTreeOption<CompInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiCompInsertCompnap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CompInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
