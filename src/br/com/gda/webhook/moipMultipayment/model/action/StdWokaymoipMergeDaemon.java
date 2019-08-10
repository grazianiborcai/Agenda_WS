package br.com.gda.webhook.moipMultipayment.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;

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
