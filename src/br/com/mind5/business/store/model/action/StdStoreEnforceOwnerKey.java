package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoreEnforceOwnerKey implements ActionStd<StoreInfo> {
	private ActionStd<StoreInfo> actionHelper;	
	
	
	public StdStoreEnforceOwnerKey(DeciTreeOption<StoreInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStoreEnforceOwnerKey());
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
