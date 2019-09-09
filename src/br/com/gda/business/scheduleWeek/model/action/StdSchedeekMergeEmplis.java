package br.com.gda.business.scheduleWeek.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdSchedeekMergeEmplis implements ActionStd<SchedeekInfo> {
	private ActionStd<SchedeekInfo> actionHelper;	
	
	
	public StdSchedeekMergeEmplis(DeciTreeOption<SchedeekInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedeekMergeEmplis(option.conn, option.schemaName));
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
