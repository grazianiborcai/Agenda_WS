package br.com.mind5.webhook.moipRefund.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class StdWokefumoipMergeDaemon implements ActionStd<WokefumoipInfo> {
	private ActionStd<WokefumoipInfo> actionHelper;	
	
	
	public StdWokefumoipMergeDaemon(DeciTreeOption<WokefumoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiWokefumoipMergeDaemon(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<WokefumoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokefumoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
