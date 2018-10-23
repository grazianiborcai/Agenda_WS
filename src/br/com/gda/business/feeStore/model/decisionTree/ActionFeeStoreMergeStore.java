package br.com.gda.business.feeStore.model.decisionTree;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionFeeStoreMergeStore implements ActionStd<FeeStoreInfo> {
	private ActionStd<FeeStoreInfo> actionHelper;	
	
	
	public ActionFeeStoreMergeStore(DeciTreeOption<FeeStoreInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisitorFeeStoreMergeStore(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FeeStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeeStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
