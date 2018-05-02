package br.com.gda.businessModel.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.businessModel.employee.dao.EmpWtimeStmtExecSelect;
import br.com.gda.businessModel.employee.info.EmpWTimeInfo;
import br.com.gda.model.decisionTree.DecisionActionAdapter;
import br.com.gda.model.decisionTree.DecisionActionStmtHelper;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public class EmpWtimeActionSelect implements DecisionActionAdapter<EmpWTimeInfo> {
	DecisionActionAdapter<EmpWTimeInfo> actionHelper;
	
	
	public EmpWtimeActionSelect(DecisionTreeOption<EmpWTimeInfo> option) {
		SqlStmtExec<EmpWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<EmpWTimeInfo> buildStmtExec(DecisionTreeOption<EmpWTimeInfo> option) {
		List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpWTimeInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpWtimeStmtExecSelect(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
