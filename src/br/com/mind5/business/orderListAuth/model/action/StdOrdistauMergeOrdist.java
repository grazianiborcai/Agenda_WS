package br.com.mind5.business.orderListAuth.model.action;

import br.com.mind5.business.orderListAuth.info.OrdistauInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdistauMergeOrdist implements ActionStd<OrdistauInfo> {
	private ActionStd<OrdistauInfo> actionHelper;	
	
	
	public StdOrdistauMergeOrdist(DeciTreeOption<OrdistauInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrdistauMergeOrdist(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdistauInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdistauInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
