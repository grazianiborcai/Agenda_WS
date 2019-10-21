package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompEnforceCreatedOn implements ActionStd<CompInfo> {
	private ActionStd<CompInfo> actionHelper;	
	
	
	public StdCompEnforceCreatedOn(DeciTreeOption<CompInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCompEnforceCreatedOn());
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
