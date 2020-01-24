package br.com.mind5.business.companyConflict.model.action;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompcoMergeToSelect implements ActionStd<CompcoInfo> {
	private ActionStd<CompcoInfo> actionHelper;	
	
	
	public StdCompcoMergeToSelect(DeciTreeOption<CompcoInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCompcoMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CompcoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompcoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
