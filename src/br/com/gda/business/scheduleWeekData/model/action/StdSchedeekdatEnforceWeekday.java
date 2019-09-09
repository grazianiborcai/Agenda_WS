package br.com.gda.business.scheduleWeekData.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedeekdatEnforceWeekday implements ActionStd<SchedeekdatInfo> {
	private ActionStd<SchedeekdatInfo> actionHelper;	
	
	
	public StdSchedeekdatEnforceWeekday(DeciTreeOption<SchedeekdatInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiSchedeekdatEnforceWeekday());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedeekdatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedeekdatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
