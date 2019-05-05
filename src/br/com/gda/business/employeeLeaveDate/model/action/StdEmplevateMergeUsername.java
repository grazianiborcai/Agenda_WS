package br.com.gda.business.employeeLeaveDate.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmplevateMergeUsername implements ActionStd<EmplevateInfo> {
	private ActionStd<EmplevateInfo> actionHelper;	
	
	
	public StdEmplevateMergeUsername(DeciTreeOption<EmplevateInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmplevateMergeUsername(option.conn, option.schemaName));
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
