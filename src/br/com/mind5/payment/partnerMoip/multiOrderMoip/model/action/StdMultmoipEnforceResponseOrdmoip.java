package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class StdMultmoipEnforceResponseOrdmoip implements ActionStd<MultmoipInfo> {
	private ActionStd<MultmoipInfo> actionHelper;	
	
	
	public StdMultmoipEnforceResponseOrdmoip(DeciTreeOption<MultmoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiMultmoipEnforceResponseOrdmoip());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MultmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MultmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
