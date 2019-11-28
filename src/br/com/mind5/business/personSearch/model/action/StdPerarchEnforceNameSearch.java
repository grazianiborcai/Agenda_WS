package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerarchEnforceNameSearch implements ActionStd<PerarchInfo> {
	private ActionStd<PerarchInfo> actionHelper;	
	
	
	public StdPerarchEnforceNameSearch(DeciTreeOption<PerarchInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPerarchEnforceNameSearch());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PerarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PerarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
