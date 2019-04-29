package br.com.gda.business.planningTime_.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdPlanMergeStowotm implements ActionStd<PlanInfo> {
	private ActionStd<PlanInfo> actionHelper;	
	
	
	public StdPlanMergeStowotm(DeciTreeOption<PlanInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPlanMergeStowotm(option.conn, option.schemaName));
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
