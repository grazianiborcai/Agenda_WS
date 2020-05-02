package br.com.mind5.business.orderList.model.action;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdistMergeOrderatus implements ActionStdV1<OrdistInfo> {
	private ActionStdV1<OrdistInfo> actionHelper;	
	
	
	public StdOrdistMergeOrderatus(DeciTreeOption<OrdistInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrdistMergeOrderatus(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OrdistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}