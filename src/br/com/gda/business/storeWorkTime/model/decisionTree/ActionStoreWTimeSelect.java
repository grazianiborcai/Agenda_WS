package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.dao.StoreWTimeSelect;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreWTimeSelect implements ActionStd<StoreWTimeInfo> {
	private ActionStd<StoreWTimeInfo> actionHelper;
	
	
	public ActionStoreWTimeSelect(DeciTreeOption<StoreWTimeInfo> option) {
		DaoStmtExec<StoreWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
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
		
		return new StoreWTimeSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoreWTimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreWTimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
