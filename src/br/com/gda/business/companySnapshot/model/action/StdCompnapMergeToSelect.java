package br.com.gda.business.companySnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCompnapMergeToSelect implements ActionStd<CompnapInfo> {
	private ActionStd<CompnapInfo> actionHelper;	
	
	
	public StdCompnapMergeToSelect(DeciTreeOption<CompnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCompnapMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CompnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
