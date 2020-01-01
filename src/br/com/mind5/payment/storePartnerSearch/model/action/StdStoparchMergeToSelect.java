package br.com.mind5.payment.storePartnerSearch.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StdStoparchMergeToSelect implements ActionStd<StoparchInfo> {
	private ActionStd<StoparchInfo> actionHelper;	
	
	
	public StdStoparchMergeToSelect(DeciTreeOption<StoparchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisStoparchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
