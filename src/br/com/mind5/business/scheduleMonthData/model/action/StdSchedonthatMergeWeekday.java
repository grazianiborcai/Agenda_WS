package br.com.mind5.business.scheduleMonthData.model.action;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
