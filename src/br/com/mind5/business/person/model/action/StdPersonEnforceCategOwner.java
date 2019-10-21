package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonEnforceCategOwner implements ActionStd<PersonInfo> {
	private ActionStd<PersonInfo> actionHelper;	
	
	
	public StdPersonEnforceCategOwner(DeciTreeOption<PersonInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersonEnforceCategOwner());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
