package br.com.mind5.business.person.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.dao.PersonInsert;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonInsert implements ActionStd<PersonInfo> {
	ActionStd<PersonInfo> actionHelper;
	
	
	public StdPersonInsert(DeciTreeOption<PersonInfo> option) {
		DaoStmtExec<PersonInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PersonInfo> buildStmtExec(DeciTreeOption<PersonInfo> option) {
		List<DaoStmtExecOption<PersonInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PersonInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PersonInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PersonInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
