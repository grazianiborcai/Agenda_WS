package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class StdRefumoipEnforceSetupNonsys implements ActionStd<RefumoipInfo> {
	private ActionStd<RefumoipInfo> actionHelper;	
	
	
	public StdRefumoipEnforceSetupNonsys(DeciTreeOption<RefumoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiRefumoipEnforceSetupNonsys());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<RefumoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<RefumoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
