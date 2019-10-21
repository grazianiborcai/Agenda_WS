package br.com.mind5.business.scheduleSearch.model.action;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedarchMergeToSelect implements ActionStd<SchedarchInfo> {
	private ActionStd<SchedarchInfo> actionHelper;	
	
	
	public StdSchedarchMergeToSelect(DeciTreeOption<SchedarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
