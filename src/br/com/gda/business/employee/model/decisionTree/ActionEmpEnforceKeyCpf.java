package br.com.gda.business.employee.model.decisionTree;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionEmpEnforceKeyCpf implements DeciAction<EmpInfo> {
	private DeciAction<EmpInfo> actionHelper;	
	
	
	public ActionEmpEnforceKeyCpf(DeciTreeOption<EmpInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorEmpEnforceKeyCpf());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<EmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
