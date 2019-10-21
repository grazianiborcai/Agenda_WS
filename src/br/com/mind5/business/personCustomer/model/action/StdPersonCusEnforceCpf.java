package br.com.mind5.business.personCustomer.model.action;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonCusEnforceCpf implements ActionStd<PersonCusInfo> {
	private ActionStd<PersonCusInfo> actionHelper;	
	
	
	public StdPersonCusEnforceCpf(DeciTreeOption<PersonCusInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersonCusEnforceCpf());
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
