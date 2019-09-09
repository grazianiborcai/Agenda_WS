package br.com.gda.business.scheduleWeekData.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdSchedeekdatMergeMonth implements ActionStd<SchedeekdatInfo> {
	private ActionStd<SchedeekdatInfo> actionHelper;	
	
	
	public StdSchedeekdatMergeMonth(DeciTreeOption<SchedeekdatInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedeekdatMergeMonth(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedeekdatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedeekdatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
