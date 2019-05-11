package br.com.gda.business.masterData.model.action;

import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStateMergeCountry implements ActionStd<StateInfo> {
	private ActionStd<StateInfo> actionHelper;	
	
	
	public StdStateMergeCountry(DeciTreeOption<StateInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStateMergeCountry(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
