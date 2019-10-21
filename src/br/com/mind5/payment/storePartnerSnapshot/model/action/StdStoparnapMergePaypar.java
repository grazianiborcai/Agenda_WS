package br.com.mind5.payment.storePartnerSnapshot.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StdStoparnapMergePaypar implements ActionStd<StoparnapInfo> {
	private ActionStd<StoparnapInfo> actionHelper;	
	
	
	public StdStoparnapMergePaypar(DeciTreeOption<StoparnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStoparnapMergePaypar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoparnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
