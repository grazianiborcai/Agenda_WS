package br.com.mind5.business.planningTime.model.action;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdPlanimeMergeDaypart implements ActionStdV1<PlanimeInfo> {
	private ActionStdV1<PlanimeInfo> actionHelper;	
	
	
	public StdPlanimeMergeDaypart(DeciTreeOption<PlanimeInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPlanimeMergeDaypart(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PlanimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PlanimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
