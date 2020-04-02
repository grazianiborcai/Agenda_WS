package br.com.mind5.business.materialMovementSearch.model.action;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmarchMergeToSelect implements ActionStdV1<MatmarchInfo> {
	private ActionStdV1<MatmarchInfo> actionHelper;	
	
	
	public StdMatmarchMergeToSelect(DeciTreeOption<MatmarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatmarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatmarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatmarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
