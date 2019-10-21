package br.com.mind5.payment.customerPartner.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class StdCusparMergeUserap implements ActionStd<CusparInfo> {
	private ActionStd<CusparInfo> actionHelper;	
	
	
	public StdCusparMergeUserap(DeciTreeOption<CusparInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCusparMergeUserap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
