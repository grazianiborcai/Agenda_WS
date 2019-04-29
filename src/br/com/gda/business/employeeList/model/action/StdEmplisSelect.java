package br.com.gda.business.employeeList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeList.dao.EmplisSelect;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
