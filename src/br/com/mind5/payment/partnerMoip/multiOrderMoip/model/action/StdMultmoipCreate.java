package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class StdMultmoipCreate implements ActionStd<MultmoipInfo> {
	private ActionStd<MultmoipInfo> actionHelper;	
	
	
	public StdMultmoipCreate(DeciTreeOption<MultmoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiMultmoipCreate(), SystemMessage.ORDER_MOIP_CREATION_ERROR, SystemCode.ORDER_MOIP_CREATION_ERROR);
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
