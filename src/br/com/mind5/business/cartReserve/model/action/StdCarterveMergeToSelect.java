package br.com.mind5.business.cartReserve.model.action;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCarterveMergeToSelect implements ActionStd<CarterveInfo> {
	private ActionStd<CarterveInfo> actionHelper;	
	
	
	public StdCarterveMergeToSelect(DeciTreeOption<CarterveInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCarterveMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CarterveInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CarterveInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
