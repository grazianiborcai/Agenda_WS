package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.AuthGrRoleSelect;
import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAuthGrRoleSelect implements ActionStdV1<AuthGrRoleInfo> {
	private ActionStdV1<AuthGrRoleInfo> actionHelper;
	
	
	public StdAuthGrRoleSelect(DeciTreeOption<AuthGrRoleInfo> option) {
		DaoStmtExec_<AuthGrRoleInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<AuthGrRoleInfo> buildStmtExec(DeciTreeOption<AuthGrRoleInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<AuthGrRoleInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AuthGrRoleInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
