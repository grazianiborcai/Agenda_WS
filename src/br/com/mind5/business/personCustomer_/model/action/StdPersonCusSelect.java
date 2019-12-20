package br.com.mind5.business.personCustomer_.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personCustomer_.dao.PersonCusSelect;
import br.com.mind5.business.personCustomer_.info.PersonCusInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonCusSelect implements ActionStd<PersonCusInfo> {
	private ActionStd<PersonCusInfo> actionHelper;
	
	
	public StdPersonCusSelect(DeciTreeOption<PersonCusInfo> option) {
		DaoStmtExec<PersonCusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PersonCusInfo> buildStmtExec(DeciTreeOption<PersonCusInfo> option) {
		List<DaoStmtExecOption<PersonCusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PersonCusInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PersonCusInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PersonCusSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonCusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonCusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
