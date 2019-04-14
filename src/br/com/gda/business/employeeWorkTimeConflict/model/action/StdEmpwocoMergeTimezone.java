package br.com.gda.business.employeeWorkTimeConflict.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpwocoMergeTimezone implements ActionStd<EmpwocoInfo> {
	private ActionStd<EmpwocoInfo> actionHelper;	
	
	
	public StdEmpwocoMergeTimezone(DeciTreeOption<EmpwocoInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmpwocoMergeTimezone(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpwocoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwocoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
