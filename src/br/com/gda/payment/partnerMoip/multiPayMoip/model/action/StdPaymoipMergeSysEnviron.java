package br.com.gda.payment.partnerMoip.multiPayMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class StdPaymoipMergeSysEnviron implements ActionStd<PaymoipInfo> {
	private ActionStd<PaymoipInfo> actionHelper;	
	
	
	public StdPaymoipMergeSysEnviron(DeciTreeOption<PaymoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPaymoipMergeSysEnviron(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
