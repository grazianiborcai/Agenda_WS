package br.com.gda.security.tokenAuthentication.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;

public final class StdTauthMergeJwtoken implements ActionStd<TauthInfo> {
	private ActionStd<TauthInfo> actionHelper;	
	
	
	public StdTauthMergeJwtoken(DeciTreeOption<TauthInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiTauthMergeJwtoken(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<TauthInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<TauthInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
