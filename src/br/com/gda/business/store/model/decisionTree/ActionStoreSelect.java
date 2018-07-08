package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreSelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class ActionStoreSelect implements DeciAction<StoreInfo> {
	private DeciAction<StoreInfo> actionHelper;
	
	
	public ActionStoreSelect(DeciTreeOption<StoreInfo> option) {
		SqlStmtExec<StoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<StoreInfo> buildStmtExec(DeciTreeOption<StoreInfo> option) {
		List<SqlStmtExecOption<StoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<StoreInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
