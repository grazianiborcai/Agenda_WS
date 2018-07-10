package br.com.gda.business.storeWorkTime.model.decisionTree;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreWTimeEnforceDel implements DeciAction<StoreWTimeInfo> {
	private DeciAction<StoreWTimeInfo> actionHelper;	
	
	
	public ActionStoreWTimeEnforceDel(DeciTreeOption<StoreWTimeInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorStoreWTimeEnforceDel());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreWTimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreWTimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
