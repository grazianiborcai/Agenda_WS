package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class StdTokemoipGenerate implements ActionStdV1<TokemoipInfo> {
	private ActionStdV1<TokemoipInfo> actionHelper;	
	
	
	public StdTokemoipGenerate(DeciTreeOption<TokemoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiTokemoipGenerate(), SystemMessage.PAY_CUS_MOIP_CREATION_ERROR, SystemCode.PAY_CUS_MOIP_CREATION_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<TokemoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<TokemoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
