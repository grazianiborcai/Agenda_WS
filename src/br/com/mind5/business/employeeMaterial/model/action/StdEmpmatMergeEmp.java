package br.com.mind5.business.employeeMaterial.model.action;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmatMergeEmp implements ActionStd<EmpmatInfo> {
	private ActionStd<EmpmatInfo> actionHelper;	
	
	
	public StdEmpmatMergeEmp(DeciTreeOption<EmpmatInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpmatMergeEmp(option.conn, option.schemaName));
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
