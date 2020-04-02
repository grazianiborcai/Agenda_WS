package br.com.mind5.business.employeeList.model.action;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplisEnforcePersonKey implements ActionStdV1<EmplisInfo> {
	private ActionStdV1<EmplisInfo> actionHelper;	
	
	
	public StdEmplisEnforcePersonKey(DeciTreeOption<EmplisInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmplisEnforcePersonKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
