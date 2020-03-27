package br.com.mind5.business.planningTime.model.action;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperPrune;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPlanimePruneDaypart implements ActionStd<PlanimeInfo> {
	private ActionStd<PlanimeInfo> actionHelper;	
	
	
	public StdPlanimePruneDaypart(DeciTreeOption<PlanimeInfo> option) {			
		actionHelper = new ActionStdHelperPrune<>(option.recordInfos, new VisiPlanimePruneDaypart());
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
