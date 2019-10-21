package br.com.mind5.payment.partnerMoip.customerMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class StdCusmoipEnforceRequest implements ActionStd<CusmoipInfo> {
	private ActionStd<CusmoipInfo> actionHelper;	
	
	
	public StdCusmoipEnforceRequest(DeciTreeOption<CusmoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCusmoipEnforceRequest());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
