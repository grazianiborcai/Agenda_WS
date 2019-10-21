package br.com.mind5.business.orderItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdOrderemSuccess implements ActionStd<OrderemInfo> {
	private ActionStd<OrderemInfo> actionHelper;
	
	
	public StdOrderemSuccess(DeciTreeOption<OrderemInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<OrderemInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<OrderemInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<OrderemInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new OrderemInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
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
