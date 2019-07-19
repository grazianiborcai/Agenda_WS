package br.com.gda.payment.partnerMoip.multiOrderMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelper;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class StdMultmoipCreate implements ActionStd<MultmoipInfo> {
	private ActionStd<MultmoipInfo> actionHelper;	
	
	
	public StdMultmoipCreate(DeciTreeOption<MultmoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiMultmoipCreate(), SystemMessage.CREDIT_CARD_MOIP_CREATION_ERROR, SystemCode.CREDIT_CARD_MOIP_CREATION_ERROR);
	}	//TODO: melhorar mensagem
	
	
	
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
