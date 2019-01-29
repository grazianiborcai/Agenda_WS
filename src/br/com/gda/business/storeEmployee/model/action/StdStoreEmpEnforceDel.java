package br.com.gda.business.storeEmployee.model.action;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStoreEmpEnforceDel implements ActionStd<StoreEmpInfo> {
	private ActionStd<StoreEmpInfo> actionHelper;	
	
	
	public StdStoreEmpEnforceDel(DeciTreeOption<StoreEmpInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisitorStoreEmpEnforceDel());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoreEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
