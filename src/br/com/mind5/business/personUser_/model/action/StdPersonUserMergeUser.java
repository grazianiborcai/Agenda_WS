package br.com.mind5.business.personUser_.model.action;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonUserMergeUser implements ActionStd<PersonUserInfo> {
	private ActionStd<PersonUserInfo> actionHelper;	
	
	
	public StdPersonUserMergeUser(DeciTreeOption<PersonUserInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersonUserMergeUser(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonUserInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonUserInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
