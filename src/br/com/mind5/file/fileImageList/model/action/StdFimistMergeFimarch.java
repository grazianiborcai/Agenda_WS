package br.com.mind5.file.fileImageList.model.action;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimistMergeFimarch implements ActionStd<FimistInfo> {
	private ActionStd<FimistInfo> actionHelper;	
	
	
	public StdFimistMergeFimarch(DeciTreeOption<FimistInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiFimistMergeFimarch(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FimistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FimistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
