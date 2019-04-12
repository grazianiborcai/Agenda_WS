package br.com.gda.business.employeeLeaveDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.dao.EmplevateUpdate;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmplevateUpdate implements ActionStd<EmplevateInfo> {
	ActionStd<EmplevateInfo> actionHelper;
	
	
	public StdEmplevateUpdate(DeciTreeOption<EmplevateInfo> option) {
		DaoStmtExec<EmplevateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmplevateInfo> buildStmtExec(DeciTreeOption<EmplevateInfo> option) {
		List<DaoStmtExecOption<EmplevateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmplevateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmplevateInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmplevateUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmplevateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplevateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
