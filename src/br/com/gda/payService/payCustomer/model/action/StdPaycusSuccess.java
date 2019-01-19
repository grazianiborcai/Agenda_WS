package br.com.gda.payService.payCustomer.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class StdPaycusSuccess implements ActionStd<PaycusInfo> {
	private ActionStd<PaycusInfo> actionHelper;
	
	
	public StdPaycusSuccess(DeciTreeOption<PaycusInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<PaycusInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<PaycusInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<PaycusInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new PaycusInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaycusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaycusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
