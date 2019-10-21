package br.com.mind5.business.order.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderSuccess implements ActionStd<OrderInfo> {
	private ActionStd<OrderInfo> actionHelper;
	
	
	public StdOrderSuccess(DeciTreeOption<OrderInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option));
	}
	
	
	
	private DeciResult<OrderInfo> buildDeciResult(DeciTreeOption<OrderInfo> option) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<OrderInfo> deciResult = new DeciResultHelper<>();
		
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<OrderInfo> resultset = new ArrayList<>();
		
		if (option.recordInfos != null)		
			resultset.addAll(option.recordInfos);
		
		deciResult.resultset = resultset;
		
		return deciResult;
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
