package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class StdPaymoipMergeSysenv implements ActionStdV1<PaymoipInfo> {
	private ActionStdV1<PaymoipInfo> actionHelper;	
	
	
	public StdPaymoipMergeSysenv(DeciTreeOption<PaymoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPaymoipMergeSysenv(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
