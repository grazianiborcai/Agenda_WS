package br.com.mind5.business.employeeList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.dao.EmplisSelect;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplisSelect implements ActionStd<EmplisInfo> {
	ActionStd<EmplisInfo> actionHelper;
	
	
	public StdEmplisSelect(DeciTreeOption<EmplisInfo> option) {
		DaoStmtExec<EmplisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmplisInfo> buildStmtExec(DeciTreeOption<EmplisInfo> option) {
		List<DaoStmtExecOption<EmplisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmplisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmplisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmplisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
