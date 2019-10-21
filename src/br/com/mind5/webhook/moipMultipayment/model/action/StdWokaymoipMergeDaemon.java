package br.com.mind5.webhook.moipMultipayment.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipMergeDaemon implements ActionStd<WokaymoipInfo> {
	private ActionStd<WokaymoipInfo> actionHelper;	
	
	
	public StdWokaymoipMergeDaemon(DeciTreeOption<WokaymoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiWokaymoipMergeDaemon(option.conn, option.schemaName));
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
