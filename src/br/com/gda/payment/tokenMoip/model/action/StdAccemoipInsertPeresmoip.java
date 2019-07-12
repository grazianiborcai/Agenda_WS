package br.com.gda.payment.tokenMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;

public final class StdAccemoipInsertPeresmoip implements ActionStd<TokemoipInfo> {
	private ActionStd<TokemoipInfo> actionHelper;	
	
	
	public StdAccemoipInsertPeresmoip(DeciTreeOption<TokemoipInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiAccemoipInsertPeresmoip(option.conn, option.schemaName));
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
