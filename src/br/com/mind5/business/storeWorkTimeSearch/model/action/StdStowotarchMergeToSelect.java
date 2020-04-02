package br.com.mind5.business.storeWorkTimeSearch.model.action;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotarchMergeToSelect implements ActionStdV1<StowotarchInfo> {
	private ActionStdV1<StowotarchInfo> actionHelper;	
	
	
	public StdStowotarchMergeToSelect(DeciTreeOption<StowotarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStowotarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StowotarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StowotarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
