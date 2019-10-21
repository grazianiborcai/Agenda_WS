package br.com.mind5.business.scheduleList.model.action;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
