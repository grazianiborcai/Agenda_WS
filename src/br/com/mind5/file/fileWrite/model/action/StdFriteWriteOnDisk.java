package br.com.mind5.file.fileWrite.model.action;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelper;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFriteWriteOnDisk implements ActionStdV1<FriteInfo> {
	private ActionStdV1<FriteInfo> actionHelper;	
	
	
	public StdFriteWriteOnDisk(DeciTreeOption<FriteInfo> option) {			
		actionHelper = new ActionStdHelper<>(option.recordInfos, new VisiFriteWriteOnDisk(), SystemMessage.FILE_WRITE_ERROR, SystemCode.FILE_WRITE_ERROR);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<FriteInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FriteInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
