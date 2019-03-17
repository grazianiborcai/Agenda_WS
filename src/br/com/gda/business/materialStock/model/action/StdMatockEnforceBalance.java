package br.com.gda.business.materialStock.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatockEnforceBalance implements ActionStd<MatockInfo> {
	private ActionStd<MatockInfo> actionHelper;	
	
	
	public StdMatockEnforceBalance(DeciTreeOption<MatockInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiMatockEnforceBalance());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatockInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatockInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
