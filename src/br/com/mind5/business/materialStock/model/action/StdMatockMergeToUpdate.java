package br.com.mind5.business.materialStock.model.action;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatockMergeToUpdate implements ActionStd<MatockInfo> {
	private ActionStd<MatockInfo> actionHelper;	
	
	
	public StdMatockMergeToUpdate(DeciTreeOption<MatockInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatockMergeToUpdate(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatockInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatockInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
