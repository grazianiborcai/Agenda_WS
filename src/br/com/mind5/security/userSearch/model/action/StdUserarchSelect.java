package br.com.mind5.security.userSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.dao.UserarchSelect;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class StdUserarchSelect implements ActionStd<UserarchInfo> {
	private ActionStd<UserarchInfo> actionHelper;
	
	
	public StdUserarchSelect(DeciTreeOption<UserarchInfo> option) {
		DaoStmtExec<UserarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<UserarchInfo> buildStmtExec(DeciTreeOption<UserarchInfo> option) {
		List<DaoStmtExecOption<UserarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(UserarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<UserarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new UserarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
