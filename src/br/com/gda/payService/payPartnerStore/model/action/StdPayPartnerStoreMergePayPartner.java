package br.com.gda.payService.payPartnerStore.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerStore.info.PayPartnerStoreInfo;

public final class StdPayPartnerStoreMergePayPartner implements ActionStd<PayPartnerStoreInfo> {
	private ActionStd<PayPartnerStoreInfo> actionHelper;	
	
	
	public StdPayPartnerStoreMergePayPartner(DeciTreeOption<PayPartnerStoreInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPayPartnerStoreMergePayPartner(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayPartnerStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayPartnerStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
