package br.com.gda.message.sysMessage.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSymsgEnforceEnglish implements ActionStd<SymsgInfo> {
	private ActionStd<SymsgInfo> actionHelper;	
	
	
	public StdSymsgEnforceEnglish(DeciTreeOption<SymsgInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiSymsgEnforceEnglish());
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
