package br.com.gda.business.employee.model.decisionTree;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionEmpEnforceDel implements ActionStd<EmpInfo> {
	private ActionStd<EmpInfo> actionHelper;	
	
	
	public ActionEmpEnforceDel(DeciTreeOption<EmpInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorEmpEnforceDel());
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
