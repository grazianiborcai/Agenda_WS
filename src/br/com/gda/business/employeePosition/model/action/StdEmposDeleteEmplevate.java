package br.com.gda.business.employeePosition.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmposDeleteEmplevate implements ActionStd<EmposInfo> {
	private ActionStd<EmposInfo> actionHelper;	
	
	
	public StdEmposDeleteEmplevate(DeciTreeOption<EmposInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiEmposDeleteEmplevate(option.conn, option.schemaName));
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
