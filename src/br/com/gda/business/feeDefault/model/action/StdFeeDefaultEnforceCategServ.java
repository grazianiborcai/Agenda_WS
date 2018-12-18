package br.com.gda.business.feeDefault.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFeeDefaultEnforceCategServ implements ActionStd<FeeDefaultInfo> {
	private ActionStd<FeeDefaultInfo> actionHelper;	
	
	
	public StdFeeDefaultEnforceCategServ(DeciTreeOption<FeeDefaultInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiFeeDefaultEnforceCategServ());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FeeDefaultInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeeDefaultInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
