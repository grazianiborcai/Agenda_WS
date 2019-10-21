package br.com.mind5.business.storeSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.dao.StorapSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorapSelect implements ActionStd<StorapInfo> {
	private ActionStd<StorapInfo> actionHelper;
	
	
	public StdStorapSelect(DeciTreeOption<StorapInfo> option) {
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
