package br.com.mind5.security.userPassword.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.dao.UpswdSelect;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdSelect implements ActionStd<UpswdInfo> {
	private ActionStd<UpswdInfo> actionHelper;
	
	
	public StdUpswdSelect(DeciTreeOption<UpswdInfo> option) {
		DaoStmtExec_<UpswdInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
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
		
		return new UpswdSelect(stmtExecOptions);
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
