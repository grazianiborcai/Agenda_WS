package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class StdPayordemEnforceSysReceiver implements ActionStd<PayordemInfo> {
	private ActionStd<PayordemInfo> actionHelper;	
	
	
	public StdPayordemEnforceSysReceiver(DeciTreeOption<PayordemInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPayordemEnforceSysReceiver());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayordemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
