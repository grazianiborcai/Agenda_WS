package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderMergeOrderem implements ActionStd<OrderInfo> {
	private ActionStd<OrderInfo> actionHelper;	
	
	
	public StdOrderMergeOrderem(DeciTreeOption<OrderInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrderMergeOrderem(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrderInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
