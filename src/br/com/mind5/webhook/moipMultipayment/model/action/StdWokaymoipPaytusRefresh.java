package br.com.mind5.webhook.moipMultipayment.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipPaytusRefresh implements ActionStdV1<WokaymoipInfo> {
	private ActionStdV1<WokaymoipInfo> actionHelper;	
	
	
	public StdWokaymoipPaytusRefresh(DeciTreeOption<WokaymoipInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiWokaymoipPaytusRefresh(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<WokaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
