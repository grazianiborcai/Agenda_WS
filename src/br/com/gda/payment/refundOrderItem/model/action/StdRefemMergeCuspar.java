package br.com.gda.payment.refundOrderItem.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;

public final class StdRefemMergeCuspar implements ActionStd<RefemInfo> {
	private ActionStd<RefemInfo> actionHelper;	
	
	
	public StdRefemMergeCuspar(DeciTreeOption<RefemInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiRefemMergeCuspar(option.conn, option.schemaName));
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
