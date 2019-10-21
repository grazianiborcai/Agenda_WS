package br.com.mind5.payment.partnerMoip.refundMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class StdRefumoipMergeSysEnviron implements ActionStd<RefumoipInfo> {
	private ActionStd<RefumoipInfo> actionHelper;	
	
	
	public StdRefumoipMergeSysEnviron(DeciTreeOption<RefumoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiRefumoipMergeSysEnviron(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<RefumoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<RefumoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
