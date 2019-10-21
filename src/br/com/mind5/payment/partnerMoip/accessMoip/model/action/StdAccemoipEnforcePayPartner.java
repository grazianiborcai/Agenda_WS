package br.com.mind5.payment.partnerMoip.accessMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipInfo;

public final class StdAccemoipEnforcePayPartner implements ActionStd<AccemoipInfo> {
	private ActionStd<AccemoipInfo> actionHelper;	
	
	
	public StdAccemoipEnforcePayPartner(DeciTreeOption<AccemoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiAccemoipEnforcePayPartner());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AccemoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AccemoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
