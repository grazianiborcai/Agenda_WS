package br.com.mind5.business.employeeSnapshot.model.action;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpnapMergeToSelect implements ActionStd<EmpnapInfo> {
	private ActionStd<EmpnapInfo> actionHelper;	
	
	
	public StdEmpnapMergeToSelect(DeciTreeOption<EmpnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpnapMergeToSelect(option.conn, option.schemaName));
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
