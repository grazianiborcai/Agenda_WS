package br.com.gda.payService.payPartnerOwner.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;

public final class StdPayparOwnerMergeOwner implements ActionStd<PayparOwnerInfo> {
	private ActionStd<PayparOwnerInfo> actionHelper;	
	
	
	public StdPayparOwnerMergeOwner(DeciTreeOption<PayparOwnerInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPayparOwnerMergeOwner(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayparOwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayparOwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
