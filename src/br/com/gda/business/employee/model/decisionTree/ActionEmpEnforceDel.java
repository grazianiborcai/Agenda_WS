package br.com.gda.business.employee.model.decisionTree;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionEmpEnforceDel implements DeciAction<EmpInfo> {
	private DeciAction<EmpInfo> actionHelper;	
	
	
	public ActionEmpEnforceDel(DeciTreeOption<EmpInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorEmpEnforceDel());
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
