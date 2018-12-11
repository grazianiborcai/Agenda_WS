package br.com.gda.business.personUser.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersonUserEnforceEntityCateg implements ActionStd<PersonUserInfo> {
	private ActionStd<PersonUserInfo> actionHelper;	
	
	
	public StdPersonUserEnforceEntityCateg(DeciTreeOption<PersonUserInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersonUserEnforceEntityCateg());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonUserInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonUserInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
