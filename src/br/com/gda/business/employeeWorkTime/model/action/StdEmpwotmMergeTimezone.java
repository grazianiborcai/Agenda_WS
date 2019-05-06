package br.com.gda.business.employeeWorkTime.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpwotmMergeTimezone implements ActionStd<EmpwotmInfo> {
	private ActionStd<EmpwotmInfo> actionHelper;	
	
	
	public StdEmpwotmMergeTimezone(DeciTreeOption<EmpwotmInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpwotmMergeTimezone(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpwotmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwotmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
