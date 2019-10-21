package br.com.mind5.business.orderList.model.action;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdistMergeCurrency implements ActionStd<OrdistInfo> {
	private ActionStd<OrdistInfo> actionHelper;	
	
	
	public StdOrdistMergeCurrency(DeciTreeOption<OrdistInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrdistMergeCurrency(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
