package br.com.gda.payment.storePartner.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartner.info.StoparInfo;

public final class StdStoparMergeToSelect implements ActionStd<StoparInfo> {
	private ActionStd<StoparInfo> actionHelper;	
	
	
	public StdStoparMergeToSelect(DeciTreeOption<StoparInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStoparMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
