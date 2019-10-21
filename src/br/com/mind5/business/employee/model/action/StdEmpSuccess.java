package br.com.mind5.business.employee.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpSuccess implements ActionStd<EmpInfo> {
	private ActionStd<EmpInfo> actionHelper;
	
	
	public StdEmpSuccess(DeciTreeOption<EmpInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<EmpInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<EmpInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<EmpInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new EmpInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
