package br.com.gda.business.user.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.dao.UserUpdate;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdUserUpdate implements ActionStd<UserInfo> {
	private ActionStd<UserInfo> actionHelper;
	
	
	public StdUserUpdate(DeciTreeOption<UserInfo> option) {
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
		
		return new UserUpdate(stmtExecOptions);
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
