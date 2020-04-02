package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSymsgEnforceError implements ActionStdV1<SymsgInfo> {
	private ActionStdV1<SymsgInfo> actionHelper;	
	
	
	public StdSymsgEnforceError(DeciTreeOption<SymsgInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiSymsgEnforceError());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<SymsgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SymsgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
