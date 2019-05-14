package br.com.gda.business.planningTime.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdPlanimeMergeMat implements ActionStd<PlanimeInfo> {
	private ActionStd<PlanimeInfo> actionHelper;	
	
	
	public StdPlanimeMergeMat(DeciTreeOption<PlanimeInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPlanimeMergeMat(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PlanimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PlanimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
