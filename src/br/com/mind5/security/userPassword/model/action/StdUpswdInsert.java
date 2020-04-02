package br.com.mind5.security.userPassword.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.dao.UpswdInsert;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdInsert implements ActionStdV1<UpswdInfo> {
	private ActionStdV1<UpswdInfo> actionHelper;
	
	
	public StdUpswdInsert(DeciTreeOption<UpswdInfo> option) {
		DaoStmtExec_<UpswdInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<UpswdInfo> buildStmtExec(DeciTreeOption<UpswdInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<UpswdInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UpswdInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
