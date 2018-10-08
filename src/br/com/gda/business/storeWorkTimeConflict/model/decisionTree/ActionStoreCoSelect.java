package br.com.gda.business.storeWorkTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTimeConflict.dao.StoreCoSelect;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionStoreCoSelect implements ActionStd<StoreCoInfo> {
	private ActionStd<StoreCoInfo> actionHelper;
	
	
	public ActionStoreCoSelect(DeciTreeOption<StoreCoInfo> option) {
		DaoStmtExec<StoreCoInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoreCoInfo> buildStmtExec(DeciTreeOption<StoreCoInfo> option) {
		List<DaoStmtExecOption<StoreCoInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreCoInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoreCoInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreCoSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoreCoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreCoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
