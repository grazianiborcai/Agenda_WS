package br.com.mind5.business.employeeMaterialSearch.model.action;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmarchMergeToSelect implements ActionStd<EmpmarchInfo> {
	private ActionStd<EmpmarchInfo> actionHelper;	
	
	
	public StdEmpmarchMergeToSelect(DeciTreeOption<EmpmarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpmarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpmarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpmarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
