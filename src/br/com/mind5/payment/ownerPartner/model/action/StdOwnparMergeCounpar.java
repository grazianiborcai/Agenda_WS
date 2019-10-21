package br.com.mind5.payment.ownerPartner.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class StdOwnparMergeCounpar implements ActionStd<OwnparInfo> {
	private ActionStd<OwnparInfo> actionHelper;	
	
	
	public StdOwnparMergeCounpar(DeciTreeOption<OwnparInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOwnparMergeCounpar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
