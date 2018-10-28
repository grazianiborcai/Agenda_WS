package br.com.gda.business.customer.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdDummy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCusSuccess implements ActionStd<CusInfo> {
	private ActionStd<CusInfo> actionHelper;
	
	
	public StdCusSuccess(DeciTreeOption<CusInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<CusInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<CusInfo> deciResult = new DeciResultHelper<>();
		deciResult.finishedWithSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<CusInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new CusInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
