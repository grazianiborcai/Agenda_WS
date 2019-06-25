package br.com.gda.payment.customerMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelper;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;

public final class StdCusmoipCreate implements ActionStd<CusmoipInfo> {
	private ActionStd<CusmoipInfo> actionHelper;	
	
	
	public StdCusmoipCreate(DeciTreeOption<CusmoipInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiCusmoipCreate(), SystemMessage.PAY_CUS_MOIP_CREATION_ERROR, SystemCode.PAY_CUS_MOIP_CREATION_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
