package br.com.gda.business.scheduleMonthData.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdSchedonthatMergeWeekday implements ActionStd<SchedonthatInfo> {
	private ActionStd<SchedonthatInfo> actionHelper;	
	
	
	public StdSchedonthatMergeWeekday(DeciTreeOption<SchedonthatInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedonthatMergeWeekday(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedonthatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedonthatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
