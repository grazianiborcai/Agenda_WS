package br.com.mind5.business.orderItem.model.action;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderemMergeWeekday implements ActionStd<OrderemInfo> {
	private ActionStd<OrderemInfo> actionHelper;	
	
	
	public StdOrderemMergeWeekday(DeciTreeOption<OrderemInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrderemMergeWeekday(option.conn, option.schemaName));
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
