package br.com.gda.payService.payPartnerStore.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;

public final class StdPayparStoreMergePaypar implements ActionStd<PayparStoreInfo> {
	private ActionStd<PayparStoreInfo> actionHelper;	
	
	
	public StdPayparStoreMergePaypar(DeciTreeOption<PayparStoreInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPayparStoreMergePaypar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayparStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayparStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
