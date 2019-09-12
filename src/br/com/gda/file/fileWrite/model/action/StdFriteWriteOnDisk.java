package br.com.gda.file.fileWrite.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelper;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.file.fileWrite.info.FriteInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFriteWriteOnDisk implements ActionStd<FriteInfo> {
	private ActionStd<FriteInfo> actionHelper;	
	
	
	public StdFriteWriteOnDisk(DeciTreeOption<FriteInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiFriteWriteOnDisk(), SystemMessage.FILE_WRITE_ERROR, SystemCode.FILE_WRITE_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FriteInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FriteInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
