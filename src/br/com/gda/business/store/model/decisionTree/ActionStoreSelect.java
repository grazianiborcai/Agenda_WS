package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreSelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionStoreSelect implements DeciAction<StoreInfo> {
	private DeciAction<StoreInfo> actionHelper;
	
	
	public ActionStoreSelect(DeciTreeOption<StoreInfo> option) {
		DaoStmtExec<StoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoreInfo> buildStmtExec(DeciTreeOption<StoreInfo> option) {
		List<DaoStmtExecOption<StoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoreInfo> stmtExecOption = new DaoStmtExecOption<>();
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
