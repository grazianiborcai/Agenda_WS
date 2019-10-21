package br.com.mind5.payment.statusPayOrder.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class StdPaytusPaytusemRefresh implements ActionStd<PaytusInfo> {
	private ActionStd<PaytusInfo> actionHelper;	
	
	
	public StdPaytusPaytusemRefresh(DeciTreeOption<PaytusInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiPaytusPaytusemRefresh(option.conn, option.schemaName));
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
