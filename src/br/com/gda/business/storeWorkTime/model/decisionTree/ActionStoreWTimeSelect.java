package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.dao.StoreWTimeSelect;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionStoreWTimeSelect implements DeciAction<StoreWTimeInfo> {
	DeciAction<StoreWTimeInfo> actionHelper;
	
	
	public ActionStoreWTimeSelect(DeciTreeOption<StoreWTimeInfo> option) {
		SqlStmtExec<StoreWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<StoreWTimeInfo> buildStmtExec(DeciTreeOption<StoreWTimeInfo> option) {
		List<SqlStmtExecOption<StoreWTimeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreWTimeInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<StoreWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreWTimeSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreWTimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreWTimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
