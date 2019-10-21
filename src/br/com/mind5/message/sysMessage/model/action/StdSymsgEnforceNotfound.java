package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSymsgEnforceNotfound implements ActionStd<SymsgInfo> {
	private ActionStd<SymsgInfo> actionHelper;	
	
	
	public StdSymsgEnforceNotfound(DeciTreeOption<SymsgInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiSymsgEnforceNotfound());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SymsgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SymsgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
