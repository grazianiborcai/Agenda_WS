package br.com.mind5.business.employeePositionSearch.model.action;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposarchMergeToSelect implements ActionStd<EmposarchInfo> {
	private ActionStd<EmposarchInfo> actionHelper;	
	
	
	public StdEmposarchMergeToSelect(DeciTreeOption<EmposarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmposarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmposarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmposarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
