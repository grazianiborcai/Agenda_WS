package br.com.gda.business.planningTime_.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPlanEnforceCodWeekday implements ActionStd<PlanInfo> {
	private ActionStd<PlanInfo> actionHelper;	
	
	
	public StdPlanEnforceCodWeekday(DeciTreeOption<PlanInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPlanEnforceCodWeekday());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PlanInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PlanInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
