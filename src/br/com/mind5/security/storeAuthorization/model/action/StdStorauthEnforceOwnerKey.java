package br.com.mind5.security.storeAuthorization.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StdStorauthEnforceOwnerKey implements ActionStdV1<StorauthInfo> {
	private ActionStdV1<StorauthInfo> actionHelper;	
	
	
	public StdStorauthEnforceOwnerKey(DeciTreeOption<StorauthInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStorauthEnforceOwnerKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StorauthInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorauthInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
