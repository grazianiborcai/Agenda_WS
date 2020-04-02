package br.com.mind5.security.username.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.dao.UsernameSelect;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StdUsernameSelect implements ActionStdV1<UsernameInfo> {
	private ActionStdV1<UsernameInfo> actionHelper;
	
	
	public StdUsernameSelect(DeciTreeOption<UsernameInfo> option) {
		DaoStmtExec_<UsernameInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<UsernameInfo> buildStmtExec(DeciTreeOption<UsernameInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<UsernameInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UsernameInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
