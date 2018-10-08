package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.dao.EmpWTimeDelete;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionEmpWTimeDelete implements ActionStd<EmpWTimeInfo> {
	private ActionStd<EmpWTimeInfo> actionHelper;
	
	
	public ActionEmpWTimeDelete(DeciTreeOption<EmpWTimeInfo> option) {
		DaoStmtExec<EmpWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpWTimeInfo> buildStmtExec(DeciTreeOption<EmpWTimeInfo> option) {
		List<DaoStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpWTimeInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpWTimeInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpWTimeDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpWTimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
