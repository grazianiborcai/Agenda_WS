package br.com.gda.business.employeeMaterial.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpmatMergeUsername implements ActionStd<EmpmatInfo> {
	private ActionStd<EmpmatInfo> actionHelper;	
	
	
	public StdEmpmatMergeUsername(DeciTreeOption<EmpmatInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiEmpmatMergeUsername(option.conn, option.schemaName));
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
