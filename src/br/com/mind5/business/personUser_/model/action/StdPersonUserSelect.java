package br.com.mind5.business.personUser_.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personUser_.dao.PersonUserSelect;
import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonUserSelect implements ActionStd<PersonUserInfo> {
	private ActionStd<PersonUserInfo> actionHelper;
	
	
	public StdPersonUserSelect(DeciTreeOption<PersonUserInfo> option) {
		DaoStmtExec<PersonUserInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PersonUserInfo> buildStmtExec(DeciTreeOption<PersonUserInfo> option) {
		List<DaoStmtExecOption<PersonUserInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PersonUserInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PersonUserInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PersonUserSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonUserInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonUserInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
