package br.com.mind5.payment.statusPayOrder.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class StdPaytusMergePaymoip implements ActionStd<PaytusInfo> {
	private ActionStd<PaytusInfo> actionHelper;	
	
	
	public StdPaytusMergePaymoip(DeciTreeOption<PaytusInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPaytusMergePaymoip(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaytusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaytusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
