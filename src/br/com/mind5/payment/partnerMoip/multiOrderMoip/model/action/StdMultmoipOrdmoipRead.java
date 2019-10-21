package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class StdMultmoipOrdmoipRead implements ActionStd<MultmoipInfo> {
	private ActionStd<MultmoipInfo> actionHelper;	
	
	
	public StdMultmoipOrdmoipRead(DeciTreeOption<MultmoipInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiMultmoipOrdmoipRead(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MultmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MultmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
