package br.com.gda.payment.partnerMoip.refundMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class StdRefumoipMergeStopar implements ActionStd<RefumoipInfo> {
	private ActionStd<RefumoipInfo> actionHelper;	
	
	
	public StdRefumoipMergeStopar(DeciTreeOption<RefumoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiRefumoipMergeStopar(option.conn, option.schemaName));
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
