package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.dao.MatStoreDelete;
import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionMatStoreDelete implements DeciAction<MatStoreInfo> {
	DeciAction<MatStoreInfo> actionHelper;
	
	
	public ActionMatStoreDelete(DeciTreeOption<MatStoreInfo> option) {
		SqlStmtExec<MatStoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<MatStoreInfo> buildStmtExec(DeciTreeOption<MatStoreInfo> option) {
		List<SqlStmtExecOption<MatStoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatStoreInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<MatStoreInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatStoreDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
