package br.com.mind5.business.cartReserveConflict.model.action;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperPrune;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartercoPruneUsername implements ActionStdV1<CartercoInfo> {
	private ActionStdV1<CartercoInfo> actionHelper;	
	
	
	public StdCartercoPruneUsername(DeciTreeOption<CartercoInfo> option) {			
		actionHelper = new ActionStdHelperPrune<>(option.recordInfos, new VisiCartercoPruneUsername(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CartercoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartercoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
