package br.com.mind5.business.scheduleSearch.model.action;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedarchMergeToSelect implements ActionStdV1<SchedarchInfo> {
	private ActionStdV1<SchedarchInfo> actionHelper;	
	
	
	public StdSchedarchMergeToSelect(DeciTreeOption<SchedarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<SchedarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
