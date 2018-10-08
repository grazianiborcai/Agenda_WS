package br.com.gda.business.planningTime.model.decisionTree;

import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionPlanEnforceWeekday implements ActionStd<PlanInfo> {
	private ActionStd<PlanInfo> actionHelper;	
	
	
	public ActionPlanEnforceWeekday(DeciTreeOption<PlanInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorPlanEnforceWeekday());
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
