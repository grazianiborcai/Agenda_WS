package br.com.mind5.business.materialStoreSnapshot.model.action;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatorapMergeToSelect implements ActionStdV1<MatorapInfo> {
	private ActionStdV1<MatorapInfo> actionHelper;	
	
	
	public StdMatorapMergeToSelect(DeciTreeOption<MatorapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatorapMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatorapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatorapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
