package br.com.mind5.webhook.moipRefund.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class StdWokefumoipMergeDaemon implements ActionStdV1<WokefumoipInfo> {
	private ActionStdV1<WokefumoipInfo> actionHelper;	
	
	
	public StdWokefumoipMergeDaemon(DeciTreeOption<WokefumoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiWokefumoipMergeDaemon(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<WokefumoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokefumoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
