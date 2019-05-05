package br.com.gda.business.customerSearch.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdCusarchMergeToSelect implements ActionStd<CusarchInfo> {
	private ActionStd<CusarchInfo> actionHelper;	
	
	
	public StdCusarchMergeToSelect(DeciTreeOption<CusarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCusarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
