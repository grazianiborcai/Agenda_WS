package br.com.gda.business.employeeMaterial.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpmatMergeToSelect implements ActionStd<EmpmatInfo> {
	private ActionStd<EmpmatInfo> actionHelper;	
	
	
	public StdEmpmatMergeToSelect(DeciTreeOption<EmpmatInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiEmpmatMergeToSelect(option.conn, option.schemaName));
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
