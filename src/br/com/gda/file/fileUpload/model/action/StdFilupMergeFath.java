package br.com.gda.file.fileUpload.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFilupMergeFath implements ActionStd<FilupInfo> {
	private ActionStd<FilupInfo> actionHelper;	
	
	
	public StdFilupMergeFath(DeciTreeOption<FilupInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiFilupMergeFath(option.conn, option.schemaName));
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
