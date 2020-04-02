package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class StdRefumoipRefund implements ActionStdV1<RefumoipInfo> {
	private ActionStdV1<RefumoipInfo> actionHelper;	
	
	
	public StdRefumoipRefund(DeciTreeOption<RefumoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiRefumoipRefund(), SystemMessage.REFUND_MOIP_REFUND_ERROR, SystemCode.REFUND_MOIP_REFUND_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<RefumoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<RefumoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
