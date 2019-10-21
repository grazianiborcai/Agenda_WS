package br.com.mind5.payment.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class StdPaymoipEnforceSetup implements ActionStd<PaymoipInfo> {
	private ActionStd<PaymoipInfo> actionHelper;	
	
	
	public StdPaymoipEnforceSetup(DeciTreeOption<PaymoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPaymoipEnforceSetup());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
