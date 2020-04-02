package br.com.mind5.business.owner.model.action;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerDeleteStore implements ActionStdV1<OwnerInfo> {
	private ActionStdV1<OwnerInfo> actionHelper;	
	
	
	public StdOwnerDeleteStore(DeciTreeOption<OwnerInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiOwnerDeleteStore(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
