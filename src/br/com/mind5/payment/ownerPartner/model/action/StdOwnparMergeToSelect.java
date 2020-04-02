package br.com.mind5.payment.ownerPartner.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class StdOwnparMergeToSelect implements ActionStdV1<OwnparInfo> {
	private ActionStdV1<OwnparInfo> actionHelper;	
	
	
	public StdOwnparMergeToSelect(DeciTreeOption<OwnparInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOwnparMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OwnparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
