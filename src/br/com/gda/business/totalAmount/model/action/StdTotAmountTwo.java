package br.com.gda.business.totalAmount.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdTotAmountTwo implements ActionStd<TotAmountInfo> {
	private ActionStd<TotAmountInfo> actionHelper;	
	
	
	public StdTotAmountTwo(DeciTreeOption<TotAmountInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiTotAmountTwo());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<TotAmountInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<TotAmountInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
