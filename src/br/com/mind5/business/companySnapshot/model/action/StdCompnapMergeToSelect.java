package br.com.mind5.business.companySnapshot.model.action;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
