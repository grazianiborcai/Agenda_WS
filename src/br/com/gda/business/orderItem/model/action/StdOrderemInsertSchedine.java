package br.com.gda.business.orderItem.model.action;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrderemInsertSchedine implements ActionStd<OrderemInfo> {
	private ActionStd<OrderemInfo> actionHelper;	
	
	
	public StdOrderemInsertSchedine(DeciTreeOption<OrderemInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiOrderemInsertSchedine(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrderemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
