package br.com.mind5.business.storeLeaveDateSearch.model.action;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolarchMergeToSelect implements ActionStd<StolarchInfo> {
	private ActionStd<StolarchInfo> actionHelper;	
	
	
	public StdStolarchMergeToSelect(DeciTreeOption<StolarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStolarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
