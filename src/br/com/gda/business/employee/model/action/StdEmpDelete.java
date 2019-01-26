package br.com.gda.business.employee.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpDelete;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpDelete implements ActionStd<EmpInfo> {
	ActionStd<EmpInfo> actionHelper;
	
	
	public StdEmpDelete(DeciTreeOption<EmpInfo> option) {
		DaoStmtExec<EmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpInfo> buildStmtExec(DeciTreeOption<EmpInfo> option) {
		List<DaoStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
