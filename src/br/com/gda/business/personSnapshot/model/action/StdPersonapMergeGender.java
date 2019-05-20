package br.com.gda.business.personSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdPersonapMergeGender implements ActionStd<PersonapInfo> {
	private ActionStd<PersonapInfo> actionHelper;	
	
	
	public StdPersonapMergeGender(DeciTreeOption<PersonapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPersonapMergeGender(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
