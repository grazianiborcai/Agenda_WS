package br.com.mind5.security.userList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.dao.UselisSelect;
import br.com.mind5.security.userList.info.UselisInfo;

public final class StdUselisSelect implements ActionStd<UselisInfo> {
	private ActionStd<UselisInfo> actionHelper;
	
	
	public StdUselisSelect(DeciTreeOption<UselisInfo> option) {
		DaoStmtExec<UselisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<UselisInfo> buildStmtExec(DeciTreeOption<UselisInfo> option) {
		List<DaoStmtExecOption<UselisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(UselisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<UselisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new UselisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UselisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UselisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
