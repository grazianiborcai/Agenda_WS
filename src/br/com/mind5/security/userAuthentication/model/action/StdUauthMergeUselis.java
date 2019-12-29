package br.com.mind5.security.userAuthentication.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class StdUauthMergeUselis implements ActionStd<UauthInfo> {
	private ActionStd<UauthInfo> actionHelper;	
	
	
	public StdUauthMergeUselis(DeciTreeOption<UauthInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiUauthMergeUselis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UauthInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UauthInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
