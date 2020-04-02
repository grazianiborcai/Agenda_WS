package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwotarchMergeToSelect implements ActionStdV1<EmpwotarchInfo> {
	private ActionStdV1<EmpwotarchInfo> actionHelper;	
	
	
	public StdEmpwotarchMergeToSelect(DeciTreeOption<EmpwotarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpwotarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpwotarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwotarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
