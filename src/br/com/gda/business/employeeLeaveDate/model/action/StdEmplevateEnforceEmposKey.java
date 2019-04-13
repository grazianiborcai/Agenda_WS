package br.com.gda.business.employeeLeaveDate.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmplevateEnforceEmposKey implements ActionStd<EmplevateInfo> {
	private ActionStd<EmplevateInfo> actionHelper;	
	
	
	public StdEmplevateEnforceEmposKey(DeciTreeOption<EmplevateInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmplevateEnforceEmposKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmplevateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplevateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
