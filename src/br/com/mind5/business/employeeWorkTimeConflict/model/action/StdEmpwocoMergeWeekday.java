package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwocoMergeWeekday implements ActionStd<EmpwocoInfo> {
	private ActionStd<EmpwocoInfo> actionHelper;	
	
	
	public StdEmpwocoMergeWeekday(DeciTreeOption<EmpwocoInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpwocoMergeWeekday(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpwocoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwocoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
