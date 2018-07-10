package br.com.gda.business.employeeWorkTime.model.decisionTree;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionEmpWTimeEnforceDel implements DeciAction<EmpWTimeInfo> {
	private DeciAction<EmpWTimeInfo> actionHelper;	
	
	
	public ActionEmpWTimeEnforceDel(DeciTreeOption<EmpWTimeInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorEmpWTimeEnforceDel());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<EmpWTimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
