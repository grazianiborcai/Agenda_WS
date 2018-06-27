package br.com.gda.business.storeWorkTimeConflict.model.decisionTree;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreCoMakeRange implements DeciAction<StoreCoInfo> {
	private DeciAction<StoreCoInfo> actionHelper;	
	
	
	public ActionStoreCoMakeRange(DeciTreeOption<StoreCoInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorStoreCoMakeRange(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreCoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreCoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
