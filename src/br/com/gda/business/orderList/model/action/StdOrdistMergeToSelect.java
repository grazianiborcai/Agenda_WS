package br.com.gda.business.orderList.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrdistMergeToSelect implements ActionStd<OrdistInfo> {
	private ActionStd<OrdistInfo> actionHelper;	
	
	
	public StdOrdistMergeToSelect(DeciTreeOption<OrdistInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrdistMergeToSelect(option.conn, option.schemaName));
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
