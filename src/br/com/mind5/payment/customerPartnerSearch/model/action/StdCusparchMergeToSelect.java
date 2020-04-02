package br.com.mind5.payment.customerPartnerSearch.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class StdCusparchMergeToSelect implements ActionStdV1<CusparchInfo> {
	private ActionStdV1<CusparchInfo> actionHelper;	
	
	
	public StdCusparchMergeToSelect(DeciTreeOption<CusparchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCusparchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CusparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
