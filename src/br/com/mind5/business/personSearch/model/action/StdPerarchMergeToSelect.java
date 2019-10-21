package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerarchMergeToSelect implements ActionStd<PerarchInfo> {
	private ActionStd<PerarchInfo> actionHelper;	
	
	
	public StdPerarchMergeToSelect(DeciTreeOption<PerarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPerarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PerarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PerarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
