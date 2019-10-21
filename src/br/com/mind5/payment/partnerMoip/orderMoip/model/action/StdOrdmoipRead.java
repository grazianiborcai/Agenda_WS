package br.com.mind5.payment.partnerMoip.orderMoip.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class StdOrdmoipRead implements ActionStd<OrdmoipInfo> {
	private ActionStd<OrdmoipInfo> actionHelper;	
	
	
	public StdOrdmoipRead(DeciTreeOption<OrdmoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiOrdmoipRead(), SystemMessage.ORDER_MOIP_READ_ERROR, SystemCode.ORDER_MOIP_READ_ERROR);
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
