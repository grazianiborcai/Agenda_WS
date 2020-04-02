package br.com.mind5.business.materialStockSearch.model.action;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatocarchMergeToSelect implements ActionStdV1<MatocarchInfo> {
	private ActionStdV1<MatocarchInfo> actionHelper;	
	
	
	public StdMatocarchMergeToSelect(DeciTreeOption<MatocarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatocarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatocarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatocarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
