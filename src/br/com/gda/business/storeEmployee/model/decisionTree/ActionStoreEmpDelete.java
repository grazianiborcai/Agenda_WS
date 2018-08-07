package br.com.gda.business.storeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeEmployee.dao.StoreEmpDelete;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionStoreEmpDelete implements DeciAction<StoreEmpInfo> {
	private DeciAction<StoreEmpInfo> actionHelper;
	
	
	public ActionStoreEmpDelete(DeciTreeOption<StoreEmpInfo> option) {
		DaoStmtExec<StoreEmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoreEmpInfo> buildStmtExec(DeciTreeOption<StoreEmpInfo> option) {
		List<DaoStmtExecOption<StoreEmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreEmpInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoreEmpInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreEmpDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
