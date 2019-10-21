package br.com.mind5.business.storeSearch.model.action;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSotarchMergeToSelect implements ActionStd<SotarchInfo> {
	private ActionStd<SotarchInfo> actionHelper;	
	
	
	public StdSotarchMergeToSelect(DeciTreeOption<SotarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSotarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SotarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SotarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
