package br.com.mind5.message.email.model.action;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmailEnforceEmabody implements ActionStd<EmailInfo> {
	private ActionStd<EmailInfo> actionHelper;	
	
	
	public StdEmailEnforceEmabody(DeciTreeOption<EmailInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmailEnforceEmabody());
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
