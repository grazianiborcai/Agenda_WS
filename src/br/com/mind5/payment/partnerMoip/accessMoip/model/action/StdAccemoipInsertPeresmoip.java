package br.com.mind5.payment.partnerMoip.accessMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipInfo;

public final class StdAccemoipInsertPeresmoip implements ActionStd<AccemoipInfo> {
	private ActionStd<AccemoipInfo> actionHelper;	
	
	
	public StdAccemoipInsertPeresmoip(DeciTreeOption<AccemoipInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiAccemoipInsertPeresmoip(option.conn, option.schemaName));
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
