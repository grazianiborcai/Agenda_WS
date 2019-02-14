package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.AuthGrRoleSelect;
import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAuthGrRoleSelect implements ActionStd<AuthGrRoleInfo> {
	private ActionStd<AuthGrRoleInfo> actionHelper;
	
	
	public StdAuthGrRoleSelect(DeciTreeOption<AuthGrRoleInfo> option) {
		DaoStmtExec<AuthGrRoleInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<AuthGrRoleInfo> buildStmtExec(DeciTreeOption<AuthGrRoleInfo> option) {
		List<DaoStmtExecOption<AuthGrRoleInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AuthGrRoleInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AuthGrRoleInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AuthGrRoleSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AuthGrRoleInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AuthGrRoleInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
