package br.com.gda.business.userSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdUserSnapMergePhoneSnap implements ActionStd<UserSnapInfo> {
	private ActionStd<UserSnapInfo> actionHelper;	
	
	
	public StdUserSnapMergePhoneSnap(DeciTreeOption<UserSnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiUserSnapMergePhoneSnap(option.conn, option.schemaName));
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
