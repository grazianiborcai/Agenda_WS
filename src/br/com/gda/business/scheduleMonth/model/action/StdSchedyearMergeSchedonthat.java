package br.com.gda.business.scheduleMonth.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedyearMergeSchedonthat implements ActionStd<SchedmonInfo> {
	private ActionStd<SchedmonInfo> actionHelper;	
	
	
	public StdSchedyearMergeSchedonthat(DeciTreeOption<SchedmonInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedmonMergeSchedonthat(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedmonInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedmonInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
