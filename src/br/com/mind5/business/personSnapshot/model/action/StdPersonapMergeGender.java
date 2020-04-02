package br.com.mind5.business.personSnapshot.model.action;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdPersonapMergeGender implements ActionStdV1<PersonapInfo> {
	private ActionStdV1<PersonapInfo> actionHelper;	
	
	
	public StdPersonapMergeGender(DeciTreeOption<PersonapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPersonapMergeGender(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PersonapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
