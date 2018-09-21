package br.com.gda.business.feeStore.model.decisionTree;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionFeeStoreDefault implements DeciAction<FeeStoreInfo> {
	private DeciAction<FeeStoreInfo> actionHelper;	
	
	
	public ActionFeeStoreDefault(DeciTreeOption<FeeStoreInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorFeeStoreDefault(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<FeeStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeeStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
