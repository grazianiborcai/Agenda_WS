package br.com.gda.business.order.model.decisionTree;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionOrderDummy implements DeciAction<OrderInfo> {
	private DeciAction<OrderInfo> actionHelper;	
	
	
	public ActionOrderDummy(DeciTreeOption<OrderInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorOrderDummy(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<OrderInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
