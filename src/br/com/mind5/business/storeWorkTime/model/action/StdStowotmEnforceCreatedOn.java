package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotmEnforceCreatedOn implements ActionStdV1<StowotmInfo> {
	private ActionStdV1<StowotmInfo> actionHelper;	
	
	
	public StdStowotmEnforceCreatedOn(DeciTreeOption<StowotmInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStowotmEnforceCreatedOn());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StowotmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StowotmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
