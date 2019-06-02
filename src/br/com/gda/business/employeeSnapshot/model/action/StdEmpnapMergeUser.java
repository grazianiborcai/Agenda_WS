package br.com.gda.business.employeeSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdEmpnapMergeUser implements ActionStd<EmpnapInfo> {
	private ActionStd<EmpnapInfo> actionHelper;	
	
	
	public StdEmpnapMergeUser(DeciTreeOption<EmpnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpnapMergeUser(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
