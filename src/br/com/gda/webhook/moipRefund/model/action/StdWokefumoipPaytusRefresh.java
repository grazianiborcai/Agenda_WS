package br.com.gda.webhook.moipRefund.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;

public final class StdWokefumoipPaytusRefresh implements ActionStd<WokefumoipInfo> {
	private ActionStd<WokefumoipInfo> actionHelper;	
	
	
	public StdWokefumoipPaytusRefresh(DeciTreeOption<WokefumoipInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiWokefumoipPaytusRefresh(option.conn, option.schemaName));
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
