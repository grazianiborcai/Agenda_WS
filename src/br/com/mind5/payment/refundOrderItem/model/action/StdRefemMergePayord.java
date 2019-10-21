package br.com.mind5.payment.refundOrderItem.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class StdRefemMergePayord implements ActionStd<RefemInfo> {
	private ActionStd<RefemInfo> actionHelper;	
	
	
	public StdRefemMergePayord(DeciTreeOption<RefemInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiRefemMergePayord(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<RefemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<RefemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
