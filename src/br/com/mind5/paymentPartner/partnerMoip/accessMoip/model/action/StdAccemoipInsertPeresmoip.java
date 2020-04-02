package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class StdAccemoipInsertPeresmoip implements ActionStdV1<AccemoipInfo> {
	private ActionStdV1<AccemoipInfo> actionHelper;	
	
	
	public StdAccemoipInsertPeresmoip(DeciTreeOption<AccemoipInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiAccemoipInsertPeresmoip(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<AccemoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AccemoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
