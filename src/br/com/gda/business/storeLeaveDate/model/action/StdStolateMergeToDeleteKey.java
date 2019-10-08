package br.com.gda.business.storeLeaveDate.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStolateMergeToDeleteKey implements ActionStd<StolateInfo> {
	private ActionStd<StolateInfo> actionHelper;	
	
	
	public StdStolateMergeToDeleteKey(DeciTreeOption<StolateInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisStolateMergeToDeleteKey(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
