package br.com.gda.business.employeeMaterial.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeMaterial.dao.EmpmatDelete;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpmatDelete implements ActionStd<EmpmatInfo> {
	private ActionStd<EmpmatInfo> actionHelper;
	
	
	public StdEmpmatDelete(DeciTreeOption<EmpmatInfo> option) {
		DaoStmtExec<EmpmatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpmatInfo> buildStmtExec(DeciTreeOption<EmpmatInfo> option) {
		List<DaoStmtExecOption<EmpmatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpmatInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpmatInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpmatDelete(stmtExecOptions);
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
