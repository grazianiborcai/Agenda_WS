package br.com.gda.security.storeAuthorization.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;

public final class StdStorauthMergeOwntore implements ActionStd<StorauthInfo> {
	private ActionStd<StorauthInfo> actionHelper;	
	
	
	public StdStorauthMergeOwntore(DeciTreeOption<StorauthInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStorauthMergeOwntore(option.conn, option.schemaName));
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
