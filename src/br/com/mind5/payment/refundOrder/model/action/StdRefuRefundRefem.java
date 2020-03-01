package br.com.mind5.payment.refundOrder.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class StdRefuRefundRefem implements ActionStd<RefuInfo> {
	private ActionStd<RefuInfo> actionHelper;	
	
	
	public StdRefuRefundRefem(DeciTreeOption<RefuInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiRefuRefundRefem(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<RefuInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<RefuInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
