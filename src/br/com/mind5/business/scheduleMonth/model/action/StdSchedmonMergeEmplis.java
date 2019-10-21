package br.com.mind5.business.scheduleMonth.model.action;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdSchedmonMergeEmplis implements ActionStd<SchedmonInfo> {
	private ActionStd<SchedmonInfo> actionHelper;	
	
	
	public StdSchedmonMergeEmplis(DeciTreeOption<SchedmonInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedmonMergeEmplis(option.conn, option.schemaName));
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
