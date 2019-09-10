package br.com.gda.file.fileUpload.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFilupEnforceCreatedOn implements ActionStd<FilupInfo> {
	private ActionStd<FilupInfo> actionHelper;	
	
	
	public StdFilupEnforceCreatedOn(DeciTreeOption<FilupInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiFilupEnforceCreatedOn());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FilupInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FilupInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
