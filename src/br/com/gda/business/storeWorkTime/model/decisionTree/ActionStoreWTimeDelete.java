package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.dao.StoreWTimeDelete;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

class ActionStoreWTimeDelete implements DeciAction<StoreWTimeInfo> {
	private DeciAction<StoreWTimeInfo> actionHelper;
	
	
	public ActionStoreWTimeDelete(DeciTreeOption<StoreWTimeInfo> option) {
		DaoStmtExec<StoreWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoreWTimeInfo> buildStmtExec(DeciTreeOption<StoreWTimeInfo> option) {
		List<DaoStmtExecOption<StoreWTimeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreWTimeInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoreWTimeInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreWTimeDelete(stmtExecOptions);
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
