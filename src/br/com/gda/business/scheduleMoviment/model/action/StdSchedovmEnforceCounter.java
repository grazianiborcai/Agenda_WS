package br.com.gda.business.scheduleMoviment.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleMoviment.info.SchedovmInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedovmEnforceCounter implements ActionStd<SchedovmInfo> {
	private ActionStd<SchedovmInfo> actionHelper;	
	
	
	public StdSchedovmEnforceCounter(DeciTreeOption<SchedovmInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiSchedovmEnforceCounter());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedovmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedovmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
