package br.com.mind5.business.storeTime_.model.action;

import br.com.mind5.business.storeTime_.info.StorimeInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorimeMergeStowotm implements ActionStd<StorimeInfo> {
	private ActionStd<StorimeInfo> actionHelper;	
	
	
	public StdStorimeMergeStowotm(DeciTreeOption<StorimeInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStorimeMergeStowotm(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StorimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
