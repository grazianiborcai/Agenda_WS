package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwoutMergeWeekday implements ActionStd<EmpwoutInfo> {
	private ActionStd<EmpwoutInfo> actionHelper;	
	
	
	public StdEmpwoutMergeWeekday(DeciTreeOption<EmpwoutInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpwoutMergeWeekday(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpwoutInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwoutInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
