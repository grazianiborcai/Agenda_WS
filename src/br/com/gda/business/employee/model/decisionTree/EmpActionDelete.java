package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpStmtExecDelete;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.decisionTree.DecisionAction;
import br.com.gda.model.decisionTree.DecisionActionStmtHelper;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpActionDelete implements DecisionAction<EmpInfo> {
	DecisionAction<EmpInfo> actionHelper;
	
	
	public EmpActionDelete(DecisionTreeOption<EmpInfo> option) {
		SqlStmtExec<EmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<EmpInfo> buildStmtExec(DecisionTreeOption<EmpInfo> option) {
		List<SqlStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<EmpInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpStmtExecDelete(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DecisionResult<EmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
