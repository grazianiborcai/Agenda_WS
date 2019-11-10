package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotmEnforceCreatedBy implements ActionStd<StowotmInfo> {
	private ActionStd<StowotmInfo> actionHelper;	
	
	
	public StdStowotmEnforceCreatedBy(DeciTreeOption<StowotmInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStowotmEnforceCreatedBy());
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
