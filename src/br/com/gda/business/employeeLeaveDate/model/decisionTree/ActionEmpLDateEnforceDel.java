package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionEmpLDateEnforceDel implements DeciAction<EmpLDateInfo> {
	private DeciAction<EmpLDateInfo> actionHelper;	
	
	
	public ActionEmpLDateEnforceDel(DeciTreeOption<EmpLDateInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorEmpLDateEnforceDel());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<EmpLDateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpLDateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
