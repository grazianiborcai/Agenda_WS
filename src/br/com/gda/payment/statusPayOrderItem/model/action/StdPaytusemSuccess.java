package br.com.gda.payment.statusPayOrderItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.statusPayOrderItem.info.PaytusemInfo;

public final class StdPaytusemSuccess implements ActionStd<PaytusemInfo> {
	private ActionStd<PaytusemInfo> actionHelper;
	
	
	public StdPaytusemSuccess(DeciTreeOption<PaytusemInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option));
	}
	
	
	
	private DeciResult<PaytusemInfo> buildDeciResult(DeciTreeOption<PaytusemInfo> option) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<PaytusemInfo> deciResult = new DeciResultHelper<>();
		
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<PaytusemInfo> resultset = new ArrayList<>();
		
		if (option.recordInfos != null)		
			resultset.addAll(option.recordInfos);
		
		deciResult.resultset = resultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaytusemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaytusemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
