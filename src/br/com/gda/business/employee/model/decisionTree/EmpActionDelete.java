package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpDeleteExec;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionStmtHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpActionDelete implements DeciAction<EmpInfo> {
	DeciAction<EmpInfo> actionHelper;
	
	
	public EmpActionDelete(DeciTreeOption<EmpInfo> option) {
		SqlStmtExec<EmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<EmpInfo> buildStmtExec(DeciTreeOption<EmpInfo> option) {
		List<SqlStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<EmpInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpDeleteExec(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
