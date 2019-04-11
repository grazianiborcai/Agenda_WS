package br.com.gda.business.employeeWorkTime.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpwotmSuccess implements ActionStd<EmpwotmInfo> {
	private ActionStd<EmpwotmInfo> actionHelper;
	
	
	public StdEmpwotmSuccess(DeciTreeOption<EmpwotmInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<EmpwotmInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<EmpwotmInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<EmpwotmInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new EmpwotmInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
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
