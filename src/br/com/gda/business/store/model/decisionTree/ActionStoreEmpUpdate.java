package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreEmpUpdateExec;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionStmtHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionStoreEmpUpdate implements DeciAction<StoreEmpInfo> {
	DeciAction<StoreEmpInfo> actionHelper;
	
	
	public ActionStoreEmpUpdate(DeciTreeOption<StoreEmpInfo> option) {
		SqlStmtExec<StoreEmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<StoreEmpInfo> buildStmtExec(DeciTreeOption<StoreEmpInfo> option) {
		List<SqlStmtExecOption<StoreEmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreEmpInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<StoreEmpInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreEmpUpdateExec(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
