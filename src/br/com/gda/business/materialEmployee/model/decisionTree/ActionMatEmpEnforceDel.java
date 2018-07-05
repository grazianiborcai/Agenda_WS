package br.com.gda.business.materialEmployee.model.decisionTree;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatEmpEnforceDel implements DeciAction<MatEmpInfo> {
	private DeciAction<MatEmpInfo> actionHelper;	
	
	
	public ActionMatEmpEnforceDel(DeciTreeOption<MatEmpInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorMatEmpEnforceDel());
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
