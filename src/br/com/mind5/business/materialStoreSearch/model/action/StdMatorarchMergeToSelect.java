package br.com.mind5.business.materialStoreSearch.model.action;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatorarchMergeToSelect implements ActionStdV1<MatorarchInfo> {
	private ActionStdV1<MatorarchInfo> actionHelper;	
	
	
	public StdMatorarchMergeToSelect(DeciTreeOption<MatorarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatorarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatorarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatorarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
