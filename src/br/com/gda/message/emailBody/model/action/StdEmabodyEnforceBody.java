package br.com.gda.message.emailBody.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.message.emailBody.info.EmabodyInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmabodyEnforceBody implements ActionStd<EmabodyInfo> {
	private ActionStd<EmabodyInfo> actionHelper;	
	
	
	public StdEmabodyEnforceBody(DeciTreeOption<EmabodyInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmabodyEnforceBody());
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
