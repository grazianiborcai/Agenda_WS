package br.com.mind5.payment.countryPartner.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class StdCounparEnforceDefault implements ActionStdV1<CounparInfo> {
	private ActionStdV1<CounparInfo> actionHelper;	
	
	
	public StdCounparEnforceDefault(DeciTreeOption<CounparInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCounparEnforceDefault());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CounparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CounparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
