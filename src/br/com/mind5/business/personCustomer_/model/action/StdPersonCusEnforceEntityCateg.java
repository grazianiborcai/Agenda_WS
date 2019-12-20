package br.com.mind5.business.personCustomer_.model.action;

import br.com.mind5.business.personCustomer_.info.PersonCusInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonCusEnforceEntityCateg implements ActionStd<PersonCusInfo> {
	private ActionStd<PersonCusInfo> actionHelper;	
	
	
	public StdPersonCusEnforceEntityCateg(DeciTreeOption<PersonCusInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersonCusEnforceEntityCateg());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonCusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonCusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
