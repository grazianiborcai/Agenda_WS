package br.com.gda.message.emailBody.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.message.emailBody.info.EmabodyInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmabodyMergeToSelect implements ActionStd<EmabodyInfo> {
	private ActionStd<EmabodyInfo> actionHelper;	
	
	
	public StdEmabodyMergeToSelect(DeciTreeOption<EmabodyInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmabodyMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmabodyInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmabodyInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
