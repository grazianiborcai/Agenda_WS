package br.com.gda.business.storeWorkTime.model.decisionTree;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreWTimeEnforceDel implements ActionStd<StoreWTimeInfo> {
	private ActionStd<StoreWTimeInfo> actionHelper;	
	
	
	public ActionStoreWTimeEnforceDel(DeciTreeOption<StoreWTimeInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisitorStoreWTimeEnforceDel());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoreWTimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreWTimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
