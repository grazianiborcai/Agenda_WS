package br.com.mind5.business.feeDefault.model.action;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeedefEnforceCategServ implements ActionStdV1<FeedefInfo> {
	private ActionStdV1<FeedefInfo> actionHelper;	
	
	
	public StdFeedefEnforceCategServ(DeciTreeOption<FeedefInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiFeedefEnforceCategServ());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<FeedefInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeedefInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
