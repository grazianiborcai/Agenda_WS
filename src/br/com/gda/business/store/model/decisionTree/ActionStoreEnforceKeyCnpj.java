package br.com.gda.business.store.model.decisionTree;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreEnforceKeyCnpj implements DeciAction<StoreInfo> {
	private DeciAction<StoreInfo> actionHelper;	
	
	
	public ActionStoreEnforceKeyCnpj(DeciTreeOption<StoreInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorStoreEnforceKeyCnpj());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
