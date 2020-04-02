package br.com.mind5.security.userSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.dao.UserapSelect;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class StdUserapSelect implements ActionStd<UserapInfo> {
	private ActionStd<UserapInfo> actionHelper;
	
	
	public StdUserapSelect(DeciTreeOption<UserapInfo> option) {
		DaoStmtExec_<UserapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<UserapInfo> buildStmtExec(DeciTreeOption<UserapInfo> option) {
		List<DaoStmtExecOption<UserapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(UserapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<UserapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new UserapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
