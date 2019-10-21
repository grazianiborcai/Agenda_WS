package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposEnforceEmpKey implements ActionStd<EmposInfo> {
	private ActionStd<EmposInfo> actionHelper;	
	
	
	public StdEmposEnforceEmpKey(DeciTreeOption<EmposInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmposEnforceEmpKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmposInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmposInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
