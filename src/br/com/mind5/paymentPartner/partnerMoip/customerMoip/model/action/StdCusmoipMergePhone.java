package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class StdCusmoipMergePhone implements ActionStd<CusmoipInfo> {
	private ActionStd<CusmoipInfo> actionHelper;	
	
	
	public StdCusmoipMergePhone(DeciTreeOption<CusmoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCusmoipMergePhone(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
