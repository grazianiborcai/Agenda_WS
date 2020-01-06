package br.com.mind5.payment.storePartnerList.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StdStoplisMergeStoparch implements ActionStd<StoplisInfo> {
	private ActionStd<StoplisInfo> actionHelper;	
	
	
	public StdStoplisMergeStoparch(DeciTreeOption<StoplisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStoplisMergeStoparch(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
