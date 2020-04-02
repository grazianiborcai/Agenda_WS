package br.com.mind5.payment.setupPartner.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class StdSetuparMergePaypar implements ActionStdV1<SetuparInfo> {
	private ActionStdV1<SetuparInfo> actionHelper;	
	
	
	public StdSetuparMergePaypar(DeciTreeOption<SetuparInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSetuparMergePaypar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<SetuparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SetuparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
