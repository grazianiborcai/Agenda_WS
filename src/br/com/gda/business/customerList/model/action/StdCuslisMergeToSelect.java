package br.com.gda.business.customerList.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCuslisMergeToSelect implements ActionStd<CuslisInfo> {
	private ActionStd<CuslisInfo> actionHelper;	
	
	
	public StdCuslisMergeToSelect(DeciTreeOption<CuslisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCuslisMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CuslisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CuslisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
