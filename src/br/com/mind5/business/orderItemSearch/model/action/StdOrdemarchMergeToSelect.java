package br.com.mind5.business.orderItemSearch.model.action;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemarchMergeToSelect implements ActionStd<OrdemarchInfo> {
	private ActionStd<OrdemarchInfo> actionHelper;	
	
	
	public StdOrdemarchMergeToSelect(DeciTreeOption<OrdemarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrdemarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdemarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdemarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
