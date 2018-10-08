package br.com.gda.business.amount.model.decisionTree;

import br.com.gda.business.amount.info.AmountInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionAmountTotal implements ActionStd<AmountInfo> {
	private ActionStd<AmountInfo> actionHelper;	
	
	
	public ActionAmountTotal(DeciTreeOption<AmountInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorAmountTotal());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AmountInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AmountInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
