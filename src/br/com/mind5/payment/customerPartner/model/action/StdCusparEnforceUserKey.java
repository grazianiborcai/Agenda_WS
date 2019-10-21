package br.com.mind5.payment.customerPartner.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class StdCusparEnforceUserKey implements ActionStd<CusparInfo> {
	private ActionStd<CusparInfo> actionHelper;	
	
	
	public StdCusparEnforceUserKey(DeciTreeOption<CusparInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCusparEnforceUserKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
