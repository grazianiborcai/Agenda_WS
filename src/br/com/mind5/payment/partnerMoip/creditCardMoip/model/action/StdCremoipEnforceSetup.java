package br.com.mind5.payment.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class StdCremoipEnforceSetup implements ActionStd<CremoipInfo> {
	private ActionStd<CremoipInfo> actionHelper;	
	
	
	public StdCremoipEnforceSetup(DeciTreeOption<CremoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCremoipEnforceSetup());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CremoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CremoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
