package br.com.mind5.business.scheduleRange.model.action;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedageMergeToSelect implements ActionStd<SchedageInfo> {
	private ActionStd<SchedageInfo> actionHelper;	
	
	
	public StdSchedageMergeToSelect(DeciTreeOption<SchedageInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedageMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedageInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedageInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
