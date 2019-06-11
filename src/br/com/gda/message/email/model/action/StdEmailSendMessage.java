package br.com.gda.message.email.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmailSendMessage implements ActionStd<EmailInfo> {
	private ActionStd<EmailInfo> actionHelper;	
	
	
	public StdEmailSendMessage(DeciTreeOption<EmailInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiEmailSendMessage());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmailInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmailInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
