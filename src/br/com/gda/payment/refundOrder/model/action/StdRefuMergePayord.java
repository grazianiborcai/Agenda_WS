package br.com.gda.payment.refundOrder.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.refundOrder.info.RefuInfo;

public final class StdRefuMergePayord implements ActionStd<RefuInfo> {
	private ActionStd<RefuInfo> actionHelper;	
	
	
	public StdRefuMergePayord(DeciTreeOption<RefuInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiRefuMergePayord(option.conn, option.schemaName));
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
