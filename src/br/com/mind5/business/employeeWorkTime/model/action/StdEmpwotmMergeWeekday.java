package br.com.mind5.business.employeeWorkTime.model.action;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwotmMergeWeekday implements ActionStd<EmpwotmInfo> {
	private ActionStd<EmpwotmInfo> actionHelper;	
	
	
	public StdEmpwotmMergeWeekday(DeciTreeOption<EmpwotmInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpwotmMergeWeekday(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpwotmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwotmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
