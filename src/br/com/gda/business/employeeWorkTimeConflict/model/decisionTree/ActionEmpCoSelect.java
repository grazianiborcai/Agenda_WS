package br.com.gda.business.employeeWorkTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTimeConflict.dao.EmpCoSelect;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class ActionEmpCoSelect implements DeciAction<EmpCoInfo> {
	private DeciAction<EmpCoInfo> actionHelper;
	
	
	public ActionEmpCoSelect(DeciTreeOption<EmpCoInfo> option) {
		SqlStmtExec<EmpCoInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<EmpCoInfo> buildStmtExec(DeciTreeOption<EmpCoInfo> option) {
		List<SqlStmtExecOption<EmpCoInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpCoInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<EmpCoInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpCoSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<EmpCoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpCoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
