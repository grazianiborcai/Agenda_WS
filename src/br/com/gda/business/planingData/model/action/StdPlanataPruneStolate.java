package br.com.gda.business.planingData.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperPrune;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPlanataPruneStolate implements ActionStd<PlanataInfo> {
	private ActionStd<PlanataInfo> actionHelper;	
	
	
	public StdPlanataPruneStolate(DeciTreeOption<PlanataInfo> option) {			
		actionHelper = new ActionStdHelperPrune<>(option.recordInfos, new VisiPlanataPruneStolate(option.conn, option.schemaName));
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
