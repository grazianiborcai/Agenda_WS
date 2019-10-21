package br.com.mind5.payment.countryPartner.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class StdCounparEnforceDefault implements ActionStd<CounparInfo> {
	private ActionStd<CounparInfo> actionHelper;	
	
	
	public StdCounparEnforceDefault(DeciTreeOption<CounparInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCounparEnforceDefault());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CounparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CounparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
