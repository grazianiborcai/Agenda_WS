package br.com.mind5.file.filePath.model.action;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFathEnforceCodImage implements ActionStd<FathInfo> {
	private ActionStd<FathInfo> actionHelper;	
	
	
	public StdFathEnforceCodImage(DeciTreeOption<FathInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiFathEnforceCodImage());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FathInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FathInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
