package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgMergeToSelect implements ActionStd<FimgInfo> {
	private ActionStd<FimgInfo> actionHelper;	
	
	
	public StdFimgMergeToSelect(DeciTreeOption<FimgInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiFimgMergeToSelect(option.conn, option.schemaName));
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
