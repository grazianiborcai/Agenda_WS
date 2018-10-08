package br.com.gda.business.store.model.decisionTree;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreEnforceKey implements ActionStd<StoreInfo> {
	private ActionStd<StoreInfo> actionHelper;	
	
	
	public ActionStoreEnforceKey(DeciTreeOption<StoreInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorStoreEnforceKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
