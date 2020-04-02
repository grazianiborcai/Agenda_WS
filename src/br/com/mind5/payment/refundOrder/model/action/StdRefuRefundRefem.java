package br.com.mind5.payment.refundOrder.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class StdRefuRefundRefem implements ActionStdV1<RefuInfo> {
	private ActionStdV1<RefuInfo> actionHelper;	
	
	
	public StdRefuRefundRefem(DeciTreeOption<RefuInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiRefuRefundRefem(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<RefuInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<RefuInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
