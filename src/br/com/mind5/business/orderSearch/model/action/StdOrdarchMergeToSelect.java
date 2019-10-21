package br.com.mind5.business.orderSearch.model.action;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdarchMergeToSelect implements ActionStd<OrdarchInfo> {
	private ActionStd<OrdarchInfo> actionHelper;	
	
	
	public StdOrdarchMergeToSelect(DeciTreeOption<OrdarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrdarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
