package br.com.gda.business.person.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.dao.PersonDelete;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersonDelete implements ActionStd<PersonInfo> {
	ActionStd<PersonInfo> actionHelper;
	
	
	public StdPersonDelete(DeciTreeOption<PersonInfo> option) {
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
		
		return new PersonDelete(stmtExecOptions);
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
