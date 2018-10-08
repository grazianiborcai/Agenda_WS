package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.dao.EmpLDateDelete;
import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionEmpLDateDelete implements ActionStd<EmpLDateInfo> {
	ActionStd<EmpLDateInfo> actionHelper;
	
	
	public ActionEmpLDateDelete(DeciTreeOption<EmpLDateInfo> option) {
		DaoStmtExec<EmpLDateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpLDateInfo> buildStmtExec(DeciTreeOption<EmpLDateInfo> option) {
		List<DaoStmtExecOption<EmpLDateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpLDateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpLDateInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpLDateDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpLDateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpLDateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
