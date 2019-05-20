package br.com.gda.business.userSnapshot_.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdUserSnapInsertPhoneSnap implements ActionStd<UserSnapInfo> {
	private ActionStd<UserSnapInfo> actionHelper;	
	
	
	public StdUserSnapInsertPhoneSnap(DeciTreeOption<UserSnapInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiUserSnapInsertPhoneSnap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
