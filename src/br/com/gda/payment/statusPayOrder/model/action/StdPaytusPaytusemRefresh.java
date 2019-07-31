package br.com.gda.payment.statusPayOrder.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;

public final class StdPaytusPaytusemRefresh implements ActionStd<PaytusInfo> {
	private ActionStd<PaytusInfo> actionHelper;	
	
	
	public StdPaytusPaytusemRefresh(DeciTreeOption<PaytusInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPaytusPaytusemRefresh(option.conn, option.schemaName));
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
