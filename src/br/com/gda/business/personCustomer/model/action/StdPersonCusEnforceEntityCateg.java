package br.com.gda.business.personCustomer.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
