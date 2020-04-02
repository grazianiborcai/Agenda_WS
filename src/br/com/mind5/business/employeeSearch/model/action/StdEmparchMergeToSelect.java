package br.com.mind5.business.employeeSearch.model.action;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmparchMergeToSelect implements ActionStdV1<EmparchInfo> {
	private ActionStdV1<EmparchInfo> actionHelper;	
	
	
	public StdEmparchMergeToSelect(DeciTreeOption<EmparchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmparchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
