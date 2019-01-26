package br.com.gda.business.employee.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpEnforceLChanged implements ActionStd<EmpInfo> {
	private ActionStd<EmpInfo> actionHelper;	
	
	
	public StdEmpEnforceLChanged(DeciTreeOption<EmpInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmpEnforceLChanged());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
