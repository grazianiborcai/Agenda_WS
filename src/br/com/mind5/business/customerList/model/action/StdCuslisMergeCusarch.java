package br.com.mind5.business.customerList.model.action;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCuslisMergeCusarch implements ActionStdV1<CuslisInfo> {
	private ActionStdV1<CuslisInfo> actionHelper;	
	
	
	public StdCuslisMergeCusarch(DeciTreeOption<CuslisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCuslisMergeCusarch(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CuslisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CuslisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
