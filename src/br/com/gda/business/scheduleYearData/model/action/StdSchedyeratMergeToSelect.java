package br.com.gda.business.scheduleYearData.model.action;

import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedyeratMergeToSelect implements ActionStd<SchedyeratInfo> {
	private ActionStd<SchedyeratInfo> actionHelper;	
	
	
	public StdSchedyeratMergeToSelect(DeciTreeOption<SchedyeratInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedyeratMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedyeratInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedyeratInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
