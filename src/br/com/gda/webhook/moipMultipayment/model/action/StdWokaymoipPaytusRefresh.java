package br.com.gda.webhook.moipMultipayment.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipPaytusRefresh implements ActionStd<WokaymoipInfo> {
	private ActionStd<WokaymoipInfo> actionHelper;	
	
	
	public StdWokaymoipPaytusRefresh(DeciTreeOption<WokaymoipInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiWokaymoipPaytusRefresh(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<WokaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
