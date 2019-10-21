package br.com.mind5.business.scheduleWeek.model.action;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedeekMergeSchedeekdat implements ActionStd<SchedeekInfo> {
	private ActionStd<SchedeekInfo> actionHelper;	
	
	
	public StdSchedeekMergeSchedeekdat(DeciTreeOption<SchedeekInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedeekMergeSchedeekdat(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedeekInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedeekInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
