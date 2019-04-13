package br.com.gda.business.employeeMaterial.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpmatSelectAll_ implements ActionStd<EmpmatInfo> {
	private ActionStd<EmpmatInfo> actionHelper;
	
	
	public StdEmpmatSelectAll_(DeciTreeOption<EmpmatInfo> option) {
		actionHelper = new StdEmpmatSelect(option);
		LazyEmpmatMergeMat mergeMaterial = new LazyEmpmatMergeMat(option.conn, option.schemaName);
		VisiEmpmatMergeEmp mergeEmployee = new VisiEmpmatMergeEmp(option.conn, option.schemaName);	
		
		actionHelper.addPostAction(mergeMaterial);
		mergeMaterial.addPostAction(mergeEmployee);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpmatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpmatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
