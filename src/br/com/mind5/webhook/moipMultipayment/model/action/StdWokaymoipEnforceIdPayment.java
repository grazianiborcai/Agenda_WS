package br.com.mind5.webhook.moipMultipayment.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipEnforceIdPayment implements ActionStdV1<WokaymoipInfo> {
	private ActionStdV1<WokaymoipInfo> actionHelper;	
	
	
	public StdWokaymoipEnforceIdPayment(DeciTreeOption<WokaymoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiWokaymoipEnforceIdPayment());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<WokaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
