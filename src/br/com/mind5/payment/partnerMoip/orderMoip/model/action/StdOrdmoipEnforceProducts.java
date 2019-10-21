package br.com.mind5.payment.partnerMoip.orderMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class StdOrdmoipEnforceProducts implements ActionStd<OrdmoipInfo> {
	private ActionStd<OrdmoipInfo> actionHelper;	
	
	
	public StdOrdmoipEnforceProducts(DeciTreeOption<OrdmoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiOrdmoipEnforceProducts());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
