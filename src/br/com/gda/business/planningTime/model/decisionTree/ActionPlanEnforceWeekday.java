package br.com.gda.business.planningTime.model.decisionTree;

import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionPlanEnforceWeekday implements DeciAction<PlanInfo> {
	private DeciAction<PlanInfo> actionHelper;	
	
	
	public ActionPlanEnforceWeekday(DeciTreeOption<PlanInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorPlanEnforceWeekday());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<PlanInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PlanInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
