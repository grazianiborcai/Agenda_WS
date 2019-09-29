package br.com.gda.business.companySearch.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.companySearch.info.ComparchInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
