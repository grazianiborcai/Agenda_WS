package br.com.mind5.business.companySearch.model.action;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdComparchMergeToSelect implements ActionStd<ComparchInfo> {
	private ActionStd<ComparchInfo> actionHelper;	
	
	
	public StdComparchMergeToSelect(DeciTreeOption<ComparchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiComparchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<ComparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ComparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
