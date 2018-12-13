package br.com.gda.business.userSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot.dao.UserSnapSelect;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdUserSnapSelect implements ActionStd<UserSnapInfo> {
	private ActionStd<UserSnapInfo> actionHelper;
	
	
	public StdUserSnapSelect(DeciTreeOption<UserSnapInfo> option) {
		DaoStmtExec<UserSnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<UserSnapInfo> buildStmtExec(DeciTreeOption<UserSnapInfo> option) {
		List<DaoStmtExecOption<UserSnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(UserSnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<UserSnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new UserSnapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
