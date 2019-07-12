package br.com.gda.payment.tokenMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;

public final class StdAccemoipEnforceScopes implements ActionStd<TokemoipInfo> {
	private ActionStd<TokemoipInfo> actionHelper;	
	
	
	public StdAccemoipEnforceScopes(DeciTreeOption<TokemoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiAccemoipEnforceScopes());
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
