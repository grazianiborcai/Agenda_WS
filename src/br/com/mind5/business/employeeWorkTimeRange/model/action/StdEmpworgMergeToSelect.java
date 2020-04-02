package br.com.mind5.business.employeeWorkTimeRange.model.action;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpworgMergeToSelect implements ActionStdV1<EmpworgInfo> {
	private ActionStdV1<EmpworgInfo> actionHelper;	
	
	
	public StdEmpworgMergeToSelect(DeciTreeOption<EmpworgInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpworgMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpworgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpworgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
