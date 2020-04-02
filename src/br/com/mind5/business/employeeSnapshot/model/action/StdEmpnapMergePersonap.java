package br.com.mind5.business.employeeSnapshot.model.action;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdEmpnapMergePersonap implements ActionStdV1<EmpnapInfo> {
	private ActionStdV1<EmpnapInfo> actionHelper;	
	
	
	public StdEmpnapMergePersonap(DeciTreeOption<EmpnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpnapMergePersonap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
