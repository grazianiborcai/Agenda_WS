package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
