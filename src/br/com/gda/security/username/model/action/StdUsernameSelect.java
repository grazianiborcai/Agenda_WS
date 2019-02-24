package br.com.gda.security.username.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.username.dao.UsernameSelect;
import br.com.gda.security.username.info.UsernameInfo;

public final class StdUsernameSelect implements ActionStd<UsernameInfo> {
	private ActionStd<UsernameInfo> actionHelper;
	
	
	public StdUsernameSelect(DeciTreeOption<UsernameInfo> option) {
		DaoStmtExec<UsernameInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<UsernameInfo> buildStmtExec(DeciTreeOption<UsernameInfo> option) {
		List<DaoStmtExecOption<UsernameInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(UsernameInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<UsernameInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new UsernameSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UsernameInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UsernameInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
