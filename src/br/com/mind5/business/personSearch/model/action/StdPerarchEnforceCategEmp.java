package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerarchEnforceCategEmp implements ActionStdV1<PerarchInfo> {
	private ActionStdV1<PerarchInfo> actionHelper;	
	
	
	public StdPerarchEnforceCategEmp(DeciTreeOption<PerarchInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPerarchEnforceCategEmp());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PerarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PerarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
