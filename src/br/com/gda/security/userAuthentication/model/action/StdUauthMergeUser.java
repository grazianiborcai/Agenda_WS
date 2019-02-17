package br.com.gda.security.userAuthentication.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userAuthentication.info.UauthInfo;

public final class StdUauthMergeUser implements ActionStd<UauthInfo> {
	private ActionStd<UauthInfo> actionHelper;	
	
	
	public StdUauthMergeUser(DeciTreeOption<UauthInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiUauthMergeUser(option.conn, option.schemaName));
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
