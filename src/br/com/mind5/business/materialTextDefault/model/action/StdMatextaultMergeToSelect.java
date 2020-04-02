package br.com.mind5.business.materialTextDefault.model.action;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextaultMergeToSelect implements ActionStdV1<MatextaultInfo> {
	private ActionStdV1<MatextaultInfo> actionHelper;	
	
	
	public StdMatextaultMergeToSelect(DeciTreeOption<MatextaultInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatextaultMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatextaultInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextaultInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
