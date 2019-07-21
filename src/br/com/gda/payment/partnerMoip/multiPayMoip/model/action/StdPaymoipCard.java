package br.com.gda.payment.partnerMoip.multiPayMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelper;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class StdPaymoipCard implements ActionStd<PaymoipInfo> {
	private ActionStd<PaymoipInfo> actionHelper;	
	
	
	public StdPaymoipCard(DeciTreeOption<PaymoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiPaymoipCard(), SystemMessage.PAY_MOIP_CREATION_ERROR, SystemCode.PAY_MOIP_CREATION_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
