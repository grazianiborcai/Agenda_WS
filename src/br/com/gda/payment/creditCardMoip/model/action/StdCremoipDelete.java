package br.com.gda.payment.creditCardMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelper;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;

public final class StdCremoipDelete implements ActionStd<CremoipInfo> {
	private ActionStd<CremoipInfo> actionHelper;	
	
	
	public StdCremoipDelete(DeciTreeOption<CremoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiCremoipDelete(), SystemMessage.CREDIT_CARD_MOIP_DELETION_ERROR, SystemCode.CREDIT_CARD_MOIP_DELETION_ERROR);
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
