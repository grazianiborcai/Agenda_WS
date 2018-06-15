package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.dao.EmpLDateInsert;
import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionEmpLDateInsert implements DeciAction<EmpLDateInfo> {
	DeciAction<EmpLDateInfo> actionHelper;
	
	
	public ActionEmpLDateInsert(DeciTreeOption<EmpLDateInfo> option) {
		SqlStmtExec<EmpLDateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelper<>(sqlStmtExecutor);
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
		
		return new EmpLDateInsert(stmtExecOptions);
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
