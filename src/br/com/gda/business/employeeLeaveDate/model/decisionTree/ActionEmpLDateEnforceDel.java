package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionEmpLDateEnforceDel implements ActionStd<EmpLDateInfo> {
	private ActionStd<EmpLDateInfo> actionHelper;	
	
	
	public ActionEmpLDateEnforceDel(DeciTreeOption<EmpLDateInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorEmpLDateEnforceDel());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpLDateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpLDateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
