package br.com.mind5.business.materialTextDefault.model.action;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextaultMergeToSelect implements ActionStd<MatextaultInfo> {
	private ActionStd<MatextaultInfo> actionHelper;	
	
	
	public StdMatextaultMergeToSelect(DeciTreeOption<MatextaultInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatextaultMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatextaultInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextaultInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
