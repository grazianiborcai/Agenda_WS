package br.com.gda.business.store.model.decisionTree;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreEnforceKeyCnpj implements ActionStd<StoreInfo> {
	private ActionStd<StoreInfo> actionHelper;	
	
	
	public ActionStoreEnforceKeyCnpj(DeciTreeOption<StoreInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisitorStoreEnforceKeyCnpj());
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
