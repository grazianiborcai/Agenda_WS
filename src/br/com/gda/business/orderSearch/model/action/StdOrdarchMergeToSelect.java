package br.com.gda.business.orderSearch.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.orderSearch.info.OrdarchInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
