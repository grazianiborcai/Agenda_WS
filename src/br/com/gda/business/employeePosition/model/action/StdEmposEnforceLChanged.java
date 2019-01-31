package br.com.gda.business.employeePosition.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmposEnforceLChanged implements ActionStd<EmposInfo> {
	private ActionStd<EmposInfo> actionHelper;	
	
	
	public StdEmposEnforceLChanged(DeciTreeOption<EmposInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmposEnforceLChanged());
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
