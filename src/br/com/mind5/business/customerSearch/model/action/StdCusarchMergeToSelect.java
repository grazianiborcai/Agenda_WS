package br.com.mind5.business.customerSearch.model.action;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
