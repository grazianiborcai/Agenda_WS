package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSymsgMergeToSelect implements ActionStdV1<SymsgInfo> {
	private ActionStdV1<SymsgInfo> actionHelper;	
	
	
	public StdSymsgMergeToSelect(DeciTreeOption<SymsgInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSymsgMergeToSelect(option.conn, option.schemaName));
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
