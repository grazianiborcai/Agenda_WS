package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotmMergeStolis implements ActionStd<StowotmInfo> {
	private ActionStd<StowotmInfo> actionHelper;	
	
	
	public StdStowotmMergeStolis(DeciTreeOption<StowotmInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStowotmMergeStolis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StowotmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StowotmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
