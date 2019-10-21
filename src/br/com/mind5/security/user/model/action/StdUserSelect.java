package br.com.mind5.security.user.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.dao.UserSelect;
import br.com.mind5.security.user.info.UserInfo;

public final class StdUserSelect implements ActionStd<UserInfo> {
	private ActionStd<UserInfo> actionHelper;
	
	
	public StdUserSelect(DeciTreeOption<UserInfo> option) {
		DaoStmtExec<UserInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<UserInfo> buildStmtExec(DeciTreeOption<UserInfo> option) {
		List<DaoStmtExecOption<UserInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(UserInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<UserInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new UserSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
