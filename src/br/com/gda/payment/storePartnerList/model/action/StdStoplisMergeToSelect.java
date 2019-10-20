package br.com.gda.payment.storePartnerList.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartnerList.info.StoplisInfo;

public final class StdStoplisMergeToSelect implements ActionStd<StoplisInfo> {
	private ActionStd<StoplisInfo> actionHelper;	
	
	
	public StdStoplisMergeToSelect(DeciTreeOption<StoplisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStoplisMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
