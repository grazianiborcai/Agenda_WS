package br.com.gda.business.materialEmployee.model.decisionTree;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatEmpEnforceDel implements ActionStd<MatEmpInfo> {
	private ActionStd<MatEmpInfo> actionHelper;	
	
	
	public ActionMatEmpEnforceDel(DeciTreeOption<MatEmpInfo> option) {			
		actionHelper = new ActionStdHelperTrans<>(option.recordInfos, new VisitorMatEmpEnforceDel());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
