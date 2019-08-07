package br.com.gda.payment.partnerMoip.customerMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class StdCusmoipMergeSysEnviron implements ActionStd<CusmoipInfo> {
	private ActionStd<CusmoipInfo> actionHelper;	
	
	
	public StdCusmoipMergeSysEnviron(DeciTreeOption<CusmoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCusmoipMergeSysEnviron(option.conn, option.schemaName));
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
