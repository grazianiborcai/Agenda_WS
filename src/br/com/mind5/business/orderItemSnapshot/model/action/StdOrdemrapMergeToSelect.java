package br.com.mind5.business.orderItemSnapshot.model.action;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemrapMergeToSelect implements ActionStd<OrdemrapInfo> {
	private ActionStd<OrdemrapInfo> actionHelper;	
	
	
	public StdOrdemrapMergeToSelect(DeciTreeOption<OrdemrapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrdemrapMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdemrapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdemrapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
