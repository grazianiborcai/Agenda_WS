package br.com.gda.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpStmtExecSelect;
import br.com.gda.employee.info.EmpInfo;
import br.com.gda.model.decisionTree.DecisionActionAdapter;
import br.com.gda.model.decisionTree.DecisionActionStmtHelper;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpActionSelect implements DecisionActionAdapter<EmpInfo> {
	DecisionActionAdapter<EmpInfo> actionHelper;
	
	
	public EmpActionSelect(DecisionTreeOption<EmpInfo> option) {
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
		
		return new EmpStmtExecSelect(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DecisionResult<EmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
