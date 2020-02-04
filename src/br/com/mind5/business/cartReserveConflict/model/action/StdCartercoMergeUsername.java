package br.com.mind5.business.cartReserveConflict.model.action;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartercoMergeUsername implements ActionStd<CartercoInfo> {
	private ActionStd<CartercoInfo> actionHelper;	
	
	
	public StdCartercoMergeUsername(DeciTreeOption<CartercoInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCartercoMergeUsername(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartercoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartercoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
