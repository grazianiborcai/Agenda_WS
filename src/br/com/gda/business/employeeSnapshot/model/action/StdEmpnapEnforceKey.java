package br.com.gda.business.employeeSnapshot.model.action;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpnapEnforceKey implements ActionStd<EmpnapInfo> {
	private ActionStd<EmpnapInfo> actionHelper;	
	
	
	public StdEmpnapEnforceKey(DeciTreeOption<EmpnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmpnapEnforceKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
