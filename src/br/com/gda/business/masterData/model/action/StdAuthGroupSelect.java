package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.AuthGroupSelect;
import br.com.gda.business.masterData.info.AuthGroupInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAuthGroupSelect implements ActionStd<AuthGroupInfo> {
	private ActionStd<AuthGroupInfo> actionHelper;
	
	
	public StdAuthGroupSelect(DeciTreeOption<AuthGroupInfo> option) {
		DaoStmtExec<AuthGroupInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<AuthGroupInfo> buildStmtExec(DeciTreeOption<AuthGroupInfo> option) {
		List<DaoStmtExecOption<AuthGroupInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AuthGroupInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AuthGroupInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AuthGroupSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AuthGroupInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AuthGroupInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
