package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.AuthGroupSelect;
import br.com.mind5.business.masterData.info.AuthGroupInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAuthGroupSelect implements ActionStdV1<AuthGroupInfo> {
	private ActionStdV1<AuthGroupInfo> actionHelper;
	
	
	public StdAuthGroupSelect(DeciTreeOption<AuthGroupInfo> option) {
		DaoStmtExec_<AuthGroupInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<AuthGroupInfo> buildStmtExec(DeciTreeOption<AuthGroupInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<AuthGroupInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AuthGroupInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
