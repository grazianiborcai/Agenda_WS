package br.com.mind5.business.employeeWorkTime.model.action;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwotmEnforceEmpKey implements ActionStd<EmpwotmInfo> {
	private ActionStd<EmpwotmInfo> actionHelper;	
	
	
	public StdEmpwotmEnforceEmpKey(DeciTreeOption<EmpwotmInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmpwotmEnforceEmpKey());
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
