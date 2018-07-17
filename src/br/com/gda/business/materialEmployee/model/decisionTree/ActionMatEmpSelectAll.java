package br.com.gda.business.materialEmployee.model.decisionTree;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionMatEmpSelectAll implements DeciAction<MatEmpInfo> {
	private DeciAction<MatEmpInfo> actionHelper;
	
	
	public ActionMatEmpSelectAll(DeciTreeOption<MatEmpInfo> option) {
		actionHelper = new ActionMatEmpSelect(option);
		HandlerMatEmpMergeMat mergeMaterial = new HandlerMatEmpMergeMat(option.conn, option.schemaName);
		HandlerMatEmpMergeEmp mergeEmployee = new HandlerMatEmpMergeEmp(option.conn, option.schemaName);	
		
		actionHelper.addPostAction(mergeMaterial);
		mergeMaterial.addPostAction(mergeEmployee);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
