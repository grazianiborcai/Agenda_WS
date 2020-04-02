package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class StdPaymoipRead implements ActionStdV1<PaymoipInfo> {
	private ActionStdV1<PaymoipInfo> actionHelper;	
	
	
	public StdPaymoipRead(DeciTreeOption<PaymoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiPaymoipRead(), SystemMessage.PAY_MOIP_READ_ERROR, SystemCode.PAY_MOIP_READ_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
