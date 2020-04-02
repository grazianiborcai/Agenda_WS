package br.com.mind5.payment.customerPartner.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class StdCusparCreateCusmoip implements ActionStdV1<CusparInfo> {
	private ActionStdV1<CusparInfo> actionHelper;	
	
	
	public StdCusparCreateCusmoip(DeciTreeOption<CusparInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiCusparCreateCusmoip(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CusparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
