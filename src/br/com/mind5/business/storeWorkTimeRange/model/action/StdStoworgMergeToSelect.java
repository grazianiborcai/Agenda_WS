package br.com.mind5.business.storeWorkTimeRange.model.action;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoworgMergeToSelect implements ActionStd<StoworgInfo> {
	private ActionStd<StoworgInfo> actionHelper;	
	
	
	public StdStoworgMergeToSelect(DeciTreeOption<StoworgInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStoworgMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoworgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoworgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
