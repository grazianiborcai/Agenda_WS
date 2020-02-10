package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class StdTokemoipMergeSyspar implements ActionStd<TokemoipInfo> {
	private ActionStd<TokemoipInfo> actionHelper;	
	
	
	public StdTokemoipMergeSyspar(DeciTreeOption<TokemoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiTokemoipMergeSyspar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<TokemoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<TokemoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
