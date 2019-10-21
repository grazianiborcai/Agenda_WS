package br.com.mind5.business.store.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.dao.StoreSelect;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoreSelect implements ActionStd<StoreInfo> {
	private ActionStd<StoreInfo> actionHelper;
	
	
	public StdStoreSelect(DeciTreeOption<StoreInfo> option) {
		DaoStmtExec<StoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
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
	
	
	
	@Override public void addPostAction(ActionLazy<StoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
