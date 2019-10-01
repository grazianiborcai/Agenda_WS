package br.com.gda.file.fileImageSearch.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFimarchMergeToSelect implements ActionStd<FimarchInfo> {
	private ActionStd<FimarchInfo> actionHelper;	
	
	
	public StdFimarchMergeToSelect(DeciTreeOption<FimarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiFimarchMergeToSelect(option.conn, option.schemaName));
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
