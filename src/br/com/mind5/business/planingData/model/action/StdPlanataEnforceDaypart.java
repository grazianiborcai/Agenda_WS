package br.com.mind5.business.planingData.model.action;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPlanataEnforceDaypart implements ActionStd<PlanataInfo> {
	private ActionStd<PlanataInfo> actionHelper;	
	
	
	public StdPlanataEnforceDaypart(DeciTreeOption<PlanataInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPlanataEnforceDaypart());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PlanataInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PlanataInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
