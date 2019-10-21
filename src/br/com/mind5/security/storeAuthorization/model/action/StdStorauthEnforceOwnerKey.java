package br.com.mind5.security.storeAuthorization.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StdStorauthEnforceOwnerKey implements ActionStd<StorauthInfo> {
	private ActionStd<StorauthInfo> actionHelper;	
	
	
	public StdStorauthEnforceOwnerKey(DeciTreeOption<StorauthInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStorauthEnforceOwnerKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StorauthInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorauthInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
