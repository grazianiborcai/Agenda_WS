package br.com.gda.business.scheduleSearch.model.action;

import br.com.gda.business.scheduleSearch.info.SchedarchInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
