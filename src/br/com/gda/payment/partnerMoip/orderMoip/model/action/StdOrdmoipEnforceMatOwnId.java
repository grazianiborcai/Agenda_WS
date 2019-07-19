package br.com.gda.payment.partnerMoip.orderMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class StdOrdmoipEnforceMatOwnId implements ActionStd<OrdmoipInfo> {
	private ActionStd<OrdmoipInfo> actionHelper;	
	
	
	public StdOrdmoipEnforceMatOwnId(DeciTreeOption<OrdmoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiOrdmoipEnforceMatOwnId());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
