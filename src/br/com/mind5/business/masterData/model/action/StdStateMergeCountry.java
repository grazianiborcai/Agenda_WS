package br.com.mind5.business.masterData.model.action;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStateMergeCountry implements ActionStdV1<StateInfo> {
	private ActionStdV1<StateInfo> actionHelper;	
	
	
	public StdStateMergeCountry(DeciTreeOption<StateInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStateMergeCountry(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
