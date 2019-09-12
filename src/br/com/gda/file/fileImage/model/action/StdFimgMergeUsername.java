package br.com.gda.file.fileImage.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFimgMergeUsername implements ActionStd<FimgInfo> {
	private ActionStd<FimgInfo> actionHelper;	
	
	
	public StdFimgMergeUsername(DeciTreeOption<FimgInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiFimgMergeUsername(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FimgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FimgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
