package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class StdCusmoipCreate implements ActionStdV1<CusmoipInfo> {
	private ActionStdV1<CusmoipInfo> actionHelper;	
	
	
	public StdCusmoipCreate(DeciTreeOption<CusmoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiCusmoipCreate(), SystemMessage.PAY_CUS_MOIP_CREATION_ERROR, SystemCode.PAY_CUS_MOIP_CREATION_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CusmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
