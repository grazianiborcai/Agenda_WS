package br.com.mind5.business.calendarDate.model.action;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalateMergeToSelect implements ActionStd<CalateInfo> {
	private ActionStd<CalateInfo> actionHelper;	
	
	
	public StdCalateMergeToSelect(DeciTreeOption<CalateInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCalateMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CalateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CalateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}