package br.com.gda.payment.statusPayOrder.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;

public final class StdPaytusEnforceOrderStatus implements ActionStd<PaytusInfo> {
	private ActionStd<PaytusInfo> actionHelper;	
	
	
	public StdPaytusEnforceOrderStatus(DeciTreeOption<PaytusInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPaytusEnforceOrderStatus());
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
