package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatTypeSelect;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class ActionMatTypeSelect implements DeciAction<MatTypeInfo> {
	private DeciAction<MatTypeInfo> actionHelper;
	
	
	public ActionMatTypeSelect(DeciTreeOption<MatTypeInfo> option) {
		SqlStmtExec<MatTypeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<MatTypeInfo> buildStmtExec(DeciTreeOption<MatTypeInfo> option) {
		List<SqlStmtExecOption<MatTypeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatTypeInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<MatTypeInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatTypeSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatTypeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatTypeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
