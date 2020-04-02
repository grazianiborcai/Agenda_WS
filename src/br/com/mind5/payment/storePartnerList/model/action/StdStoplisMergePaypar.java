package br.com.mind5.payment.storePartnerList.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StdStoplisMergePaypar implements ActionStdV1<StoplisInfo> {
	private ActionStdV1<StoplisInfo> actionHelper;	
	
	
	public StdStoplisMergePaypar(DeciTreeOption<StoplisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStoplisMergePaypar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StoplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
