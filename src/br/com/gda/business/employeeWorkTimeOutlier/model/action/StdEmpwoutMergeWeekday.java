package br.com.gda.business.employeeWorkTimeOutlier.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
