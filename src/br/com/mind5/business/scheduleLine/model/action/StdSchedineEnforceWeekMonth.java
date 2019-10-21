package br.com.mind5.business.scheduleLine.model.action;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedineEnforceWeekMonth implements ActionStd<SchedineInfo> {
	private ActionStd<SchedineInfo> actionHelper;	
	
	
	public StdSchedineEnforceWeekMonth(DeciTreeOption<SchedineInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiSchedineEnforceWeekMonth());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedineInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedineInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
