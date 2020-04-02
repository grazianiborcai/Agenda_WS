package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplateEnforceValidFrom implements ActionStdV1<EmplateInfo> {
	private ActionStdV1<EmplateInfo> actionHelper;	
	
	
	public StdEmplateEnforceValidFrom(DeciTreeOption<EmplateInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmplateEnforceValidFrom());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmplateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
