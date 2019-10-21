package br.com.mind5.business.personSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.dao.PersonapSelect;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonapSelect implements ActionStd<PersonapInfo> {
	ActionStd<PersonapInfo> actionHelper;
	
	
	public StdPersonapSelect(DeciTreeOption<PersonapInfo> option) {
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
		
		return new PersonapSelect(stmtExecOptions);
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
