package br.com.gda.security.userPassword.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userPassword.dao.UpswdInsert;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class StdUpswdInsert implements ActionStd<UpswdInfo> {
	private ActionStd<UpswdInfo> actionHelper;
	
	
	public StdUpswdInsert(DeciTreeOption<UpswdInfo> option) {
		DaoStmtExec<UpswdInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<UpswdInfo> buildStmtExec(DeciTreeOption<UpswdInfo> option) {
		List<DaoStmtExecOption<UpswdInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(UpswdInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<UpswdInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new UpswdInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UpswdInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UpswdInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
