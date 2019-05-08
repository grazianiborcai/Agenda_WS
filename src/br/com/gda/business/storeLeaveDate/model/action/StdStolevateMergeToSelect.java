package br.com.gda.business.storeLeaveDate.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStolevateMergeToSelect implements ActionStd<StolevateInfo> {
	private ActionStd<StolevateInfo> actionHelper;	
	
	
	public StdStolevateMergeToSelect(DeciTreeOption<StolevateInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStolevateMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolevateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolevateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
