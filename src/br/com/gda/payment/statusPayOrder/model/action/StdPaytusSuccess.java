package br.com.gda.payment.statusPayOrder.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;

public final class StdPaytusSuccess implements ActionStd<PaytusInfo> {
	private ActionStd<PaytusInfo> actionHelper;
	
	
	public StdPaytusSuccess(DeciTreeOption<PaytusInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option));
	}
	
	
	
	private DeciResult<PaytusInfo> buildDeciResult(DeciTreeOption<PaytusInfo> option) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<PaytusInfo> deciResult = new DeciResultHelper<>();
		
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<PaytusInfo> resultset = new ArrayList<>();
		
		if (option.recordInfos != null)		
			resultset.addAll(option.recordInfos);
		
		deciResult.resultset = resultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaytusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaytusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
