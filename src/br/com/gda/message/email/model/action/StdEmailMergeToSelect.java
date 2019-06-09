package br.com.gda.message.email.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmailMergeToSelect implements ActionStd<EmailInfo> {
	private ActionStd<EmailInfo> actionHelper;	
	
	
	public StdEmailMergeToSelect(DeciTreeOption<EmailInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmailMergeToSelect(option.conn, option.schemaName));
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
