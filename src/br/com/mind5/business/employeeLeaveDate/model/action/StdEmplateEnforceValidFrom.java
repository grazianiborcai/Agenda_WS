package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplateEnforceValidFrom implements ActionStd<EmplateInfo> {
	private ActionStd<EmplateInfo> actionHelper;	
	
	
	public StdEmplateEnforceValidFrom(DeciTreeOption<EmplateInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmplateEnforceValidFrom());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmplateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
