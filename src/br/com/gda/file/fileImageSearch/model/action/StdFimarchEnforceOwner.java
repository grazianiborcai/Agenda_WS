package br.com.gda.file.fileImageSearch.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFimarchEnforceOwner implements ActionStd<FimarchInfo> {
	private ActionStd<FimarchInfo> actionHelper;	
	
	
	public StdFimarchEnforceOwner(DeciTreeOption<FimarchInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiFimarchEnforceOwner());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FimarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FimarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
