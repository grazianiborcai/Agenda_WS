package br.com.gda.business.storeSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeSnapshot.dao.StorapSelect;
import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStoreSelect implements ActionStd<StorapInfo> {
	private ActionStd<StorapInfo> actionHelper;
	
	
	public StdStoreSelect(DeciTreeOption<StorapInfo> option) {
		DaoStmtExec<StorapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StorapInfo> buildStmtExec(DeciTreeOption<StorapInfo> option) {
		List<DaoStmtExecOption<StorapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StorapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StorapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StorapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StorapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
