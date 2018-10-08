package br.com.gda.business.storeWorkTimeConflict.model.decisionTree;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreCoMakeRange implements ActionStd<StoreCoInfo> {
	private ActionStd<StoreCoInfo> actionHelper;	
	
	
	public ActionStoreCoMakeRange(DeciTreeOption<StoreCoInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorStoreCoMakeRange(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoreCoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreCoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
