package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.dao.EmpLDateUpdate;
import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionEmpLDateUpdate implements DeciAction<EmpLDateInfo> {
	DeciAction<EmpLDateInfo> actionHelper;
	
	
	public ActionEmpLDateUpdate(DeciTreeOption<EmpLDateInfo> option) {
		SqlStmtExec<EmpLDateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<EmpLDateInfo> buildStmtExec(DeciTreeOption<EmpLDateInfo> option) {
		List<SqlStmtExecOption<EmpLDateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpLDateInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<EmpLDateInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpLDateUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<EmpLDateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpLDateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
