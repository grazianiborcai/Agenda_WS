package br.com.mind5.business.planingDataSearch.model.action;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperPrune;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPlanarchPruneSel implements ActionStdV1<PlanarchInfo> {
	private ActionStdV1<PlanarchInfo> actionHelper;	
	
	
	public StdPlanarchPruneSel(DeciTreeOption<PlanarchInfo> option) {			
		actionHelper = new ActionStdHelperPrune<>(option.recordInfos, new VisiPlanarchPruneSel());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PlanarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PlanarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
