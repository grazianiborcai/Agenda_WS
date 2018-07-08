package br.com.gda.business.materialEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.dao.MatEmpUpdate;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class ActionMatEmpUpdate implements DeciAction<MatEmpInfo> {
	DeciAction<MatEmpInfo> actionHelper;
	
	
	public ActionMatEmpUpdate(DeciTreeOption<MatEmpInfo> option) {
		SqlStmtExec<MatEmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<MatEmpInfo> buildStmtExec(DeciTreeOption<MatEmpInfo> option) {
		List<SqlStmtExecOption<MatEmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatEmpInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<MatEmpInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatEmpUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
