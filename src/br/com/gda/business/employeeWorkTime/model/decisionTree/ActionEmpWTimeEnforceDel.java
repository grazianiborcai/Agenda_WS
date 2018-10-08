package br.com.gda.business.employeeWorkTime.model.decisionTree;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionEmpWTimeEnforceDel implements ActionStd<EmpWTimeInfo> {
	private ActionStd<EmpWTimeInfo> actionHelper;	
	
	
	public ActionEmpWTimeEnforceDel(DeciTreeOption<EmpWTimeInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorEmpWTimeEnforceDel());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpWTimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
