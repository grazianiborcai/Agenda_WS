package br.com.mind5.payment.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

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
