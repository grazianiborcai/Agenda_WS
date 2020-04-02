package br.com.mind5.business.materialTextSearch.model.action;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextarchMergeToSelect implements ActionStdV1<MatextarchInfo> {
	private ActionStdV1<MatextarchInfo> actionHelper;	
	
	
	public StdMatextarchMergeToSelect(DeciTreeOption<MatextarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatextarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatextarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
