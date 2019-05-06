package br.com.gda.business.feeStore.model.action;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFeetoreMergeToSelect implements ActionStd<FeetoreInfo> {
	private ActionStd<FeetoreInfo> actionHelper;	
	
	
	public StdFeetoreMergeToSelect(DeciTreeOption<FeetoreInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiFeetoreMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FeetoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeetoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
