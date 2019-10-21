package br.com.mind5.payment.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class StdCremoipAdd implements ActionStd<CremoipInfo> {
	private ActionStd<CremoipInfo> actionHelper;	
	
	
	public StdCremoipAdd(DeciTreeOption<CremoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiCremoipAdd(), SystemMessage.CREDIT_CARD_MOIP_CREATION_ERROR, SystemCode.CREDIT_CARD_MOIP_CREATION_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CremoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CremoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
