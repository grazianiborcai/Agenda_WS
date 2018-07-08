package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.dao.EmpWTimeInsert;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class ActionEmpWTimeInsert implements DeciAction<EmpWTimeInfo> {
	private DeciAction<EmpWTimeInfo> actionHelper;
	
	
	public ActionEmpWTimeInsert(DeciTreeOption<EmpWTimeInfo> option) {
		SqlStmtExec<EmpWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<EmpWTimeInfo> buildStmtExec(DeciTreeOption<EmpWTimeInfo> option) {
		List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpWTimeInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpWTimeInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<EmpWTimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
