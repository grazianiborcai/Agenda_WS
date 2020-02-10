package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class StdMultmoipRead implements ActionStd<MultmoipInfo> {
	private ActionStd<MultmoipInfo> actionHelper;	
	
	
	public StdMultmoipRead(DeciTreeOption<MultmoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiMultmoipRead(), SystemMessage.MULT_MOIP_READ_ERROR, SystemCode.MULT_MOIP_READ_ERROR);
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