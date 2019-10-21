package br.com.mind5.business.scheduleYear.model.action;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdSchedyearMergeStolis implements ActionStd<SchedyearInfo> {
	private ActionStd<SchedyearInfo> actionHelper;	
	
	
	public StdSchedyearMergeStolis(DeciTreeOption<SchedyearInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedyearMergeStolis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedyearInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedyearInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
