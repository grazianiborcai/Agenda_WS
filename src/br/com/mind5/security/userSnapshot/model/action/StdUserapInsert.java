package br.com.mind5.security.userSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.dao.UserapInsert;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class StdUserapInsert implements ActionStdV1<UserapInfo> {
	private ActionStdV1<UserapInfo> actionHelper;
	
	
	public StdUserapInsert(DeciTreeOption<UserapInfo> option) {
		DaoStmtExec_<UserapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
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
		
		return new UserapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<UserapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
