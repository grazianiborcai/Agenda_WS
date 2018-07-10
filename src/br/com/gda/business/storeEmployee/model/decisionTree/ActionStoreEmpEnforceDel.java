package br.com.gda.business.storeEmployee.model.decisionTree;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreEmpEnforceDel implements DeciAction<StoreEmpInfo> {
	private DeciAction<StoreEmpInfo> actionHelper;	
	
	
	public ActionStoreEmpEnforceDel(DeciTreeOption<StoreEmpInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorStoreEmpEnforceDel());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
