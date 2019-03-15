package br.com.gda.business.storeLeaveDate.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStolevateMergeToDelete implements ActionStd<StolevateInfo> {
	private ActionStd<StolevateInfo> actionHelper;	
	
	
	public StdStolevateMergeToDelete(DeciTreeOption<StolevateInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStolevateMergeToDelete(option.conn, option.schemaName));
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
