package br.com.gda.business.amount.model.decisionTree;

import br.com.gda.business.amount.info.AmountInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionAmountTotal implements DeciAction<AmountInfo> {
	private DeciAction<AmountInfo> actionHelper;	
	
	
	public ActionAmountTotal(DeciTreeOption<AmountInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorAmountTotal());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<AmountInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AmountInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
