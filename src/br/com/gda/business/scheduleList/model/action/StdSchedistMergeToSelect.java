package br.com.gda.business.scheduleList.model.action;

import br.com.gda.business.scheduleList.info.SchedistInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedistMergeToSelect implements ActionStd<SchedistInfo> {
	private ActionStd<SchedistInfo> actionHelper;	
	
	
	public StdSchedistMergeToSelect(DeciTreeOption<SchedistInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedistMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
