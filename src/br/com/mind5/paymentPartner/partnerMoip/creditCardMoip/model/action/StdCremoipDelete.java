package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class StdCremoipDelete implements ActionStdV1<CremoipInfo> {
	private ActionStdV1<CremoipInfo> actionHelper;	
	
	
	public StdCremoipDelete(DeciTreeOption<CremoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiCremoipDelete(), SystemMessage.CREDIT_CARD_MOIP_DELETION_ERROR, SystemCode.CREDIT_CARD_MOIP_DELETION_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CremoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CremoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
