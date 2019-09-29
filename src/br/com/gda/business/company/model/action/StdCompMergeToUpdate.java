package br.com.gda.business.company.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCompMergeToUpdate implements ActionStd<CompInfo> {
	private ActionStd<CompInfo> actionHelper;	
	
	
	public StdCompMergeToUpdate(DeciTreeOption<CompInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCompMergeToUpdate(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CompInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
