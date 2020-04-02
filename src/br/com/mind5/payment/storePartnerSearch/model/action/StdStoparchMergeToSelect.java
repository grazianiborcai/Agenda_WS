package br.com.mind5.payment.storePartnerSearch.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StdStoparchMergeToSelect implements ActionStdV1<StoparchInfo> {
	private ActionStdV1<StoparchInfo> actionHelper;	
	
	
	public StdStoparchMergeToSelect(DeciTreeOption<StoparchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisStoparchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StoparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
