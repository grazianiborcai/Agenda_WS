package br.com.gda.business.userSnapshot_.model.action;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdUserSnapMergePersonCus implements ActionStd<UserSnapInfo> {
	private ActionStd<UserSnapInfo> actionHelper;	
	
	
	public StdUserSnapMergePersonCus(DeciTreeOption<UserSnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiUserSnapMergePersonCus(option.conn, option.schemaName));
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
