package br.com.gda.business.employee.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpDeleteEmpos implements ActionStd<EmpInfo> {
	private ActionStd<EmpInfo> actionHelper;	
	
	
	public StdEmpDeleteEmpos(DeciTreeOption<EmpInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiEmpDeleteEmpos(option.conn, option.schemaName));
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
