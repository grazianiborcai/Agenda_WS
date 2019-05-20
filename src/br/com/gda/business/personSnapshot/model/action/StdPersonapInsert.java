package br.com.gda.business.personSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.dao.PersonapInsert;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersonapInsert implements ActionStd<PersonapInfo> {
	ActionStd<PersonapInfo> actionHelper;
	
	
	public StdPersonapInsert(DeciTreeOption<PersonapInfo> option) {
		DaoStmtExec<PersonapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PersonapInfo> buildStmtExec(DeciTreeOption<PersonapInfo> option) {
		List<DaoStmtExecOption<PersonapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PersonapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PersonapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PersonapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
