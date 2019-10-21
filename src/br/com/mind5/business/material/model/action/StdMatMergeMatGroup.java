package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatMergeMatGroup implements ActionStd<MatInfo> {
	private ActionStd<MatInfo> actionHelper;	
	
	
	public StdMatMergeMatGroup(DeciTreeOption<MatInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatMergeMatGroup(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
