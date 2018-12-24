package br.com.gda.business.order.model.action;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdOrderInsertCartSnap implements ActionStd<OrderInfo> {
	private ActionStd<OrderInfo> actionHelper;	
	
	
	public StdOrderInsertCartSnap(DeciTreeOption<OrderInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiOrderInsertCartSnap(option.conn, option.schemaName));
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
