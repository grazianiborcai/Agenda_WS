package br.com.mind5.business.planningTime.model.action;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdPlanimeMergeMatlis implements ActionStd<PlanimeInfo> {
	private ActionStd<PlanimeInfo> actionHelper;	
	
	
	public StdPlanimeMergeMatlis(DeciTreeOption<PlanimeInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPlanimeMergeMatlis(option.conn, option.schemaName));
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
