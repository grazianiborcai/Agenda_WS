package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class StdAccemoipMergeSyspar implements ActionStd<AccemoipInfo> {
	private ActionStd<AccemoipInfo> actionHelper;	
	
	
	public StdAccemoipMergeSyspar(DeciTreeOption<AccemoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiAccemoipMergeSyspar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AccemoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AccemoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
