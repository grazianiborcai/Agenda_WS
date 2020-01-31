package br.com.mind5.business.employeeList.model.action;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdEmplisMergePersores implements ActionStd<EmplisInfo> {
	private ActionStd<EmplisInfo> actionHelper;	
	
	
	public StdEmplisMergePersores(DeciTreeOption<EmplisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmplisMergePersores(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}