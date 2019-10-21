package br.com.mind5.payment.storePartner.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StdStoparEnforceLChanged implements ActionStd<StoparInfo> {
	private ActionStd<StoparInfo> actionHelper;	
	
	
	public StdStoparEnforceLChanged(DeciTreeOption<StoparInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStoparEnforceLChanged());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
