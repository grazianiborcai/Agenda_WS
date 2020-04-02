package br.com.mind5.business.person.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.dao.PersonInsert;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonInsert implements ActionStdV1<PersonInfo> {
	ActionStdV1<PersonInfo> actionHelper;
	
	
	public StdPersonInsert(DeciTreeOption<PersonInfo> option) {
		DaoStmtExec_<PersonInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PersonInfo> buildStmtExec(DeciTreeOption<PersonInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<PersonInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
