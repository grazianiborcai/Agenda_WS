package br.com.gda.business.orderReserve.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrderveEnforceCancelled implements ActionStd<OrderveInfo> {
	private ActionStd<OrderveInfo> actionHelper;	
	
	
	public StdOrderveEnforceCancelled(DeciTreeOption<OrderveInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiOrderveEnforceCancelled());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrderveInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderveInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
