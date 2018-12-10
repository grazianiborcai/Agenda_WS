package br.com.gda.business.personSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.dao.PersonSnapInsert;
import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersonSnapInsert implements ActionStd<PersonSnapInfo> {
	ActionStd<PersonSnapInfo> actionHelper;
	
	
	public StdPersonSnapInsert(DeciTreeOption<PersonSnapInfo> option) {
		DaoStmtExec<PersonSnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PersonSnapInfo> buildStmtExec(DeciTreeOption<PersonSnapInfo> option) {
		List<DaoStmtExecOption<PersonSnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PersonSnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PersonSnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PersonSnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
