package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.dao.MatInsertTextExec;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionStmtHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionMatInsertText implements DeciAction<MatInfo> {
	DeciAction<MatInfo> actionHelper;
	
	
	public ActionMatInsertText(DeciTreeOption<MatInfo> option) {
		SqlStmtExec<MatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<MatInfo> buildStmtExec(DeciTreeOption<MatInfo> option) {
		List<SqlStmtExecOption<MatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<MatInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatInsertTextExec(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
