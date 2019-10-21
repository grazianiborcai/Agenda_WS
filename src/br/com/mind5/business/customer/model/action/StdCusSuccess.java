package br.com.mind5.business.customer.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusSuccess implements ActionStd<CusInfo> {
	private ActionStd<CusInfo> actionHelper;
	
	
	public StdCusSuccess(DeciTreeOption<CusInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<CusInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<CusInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
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
