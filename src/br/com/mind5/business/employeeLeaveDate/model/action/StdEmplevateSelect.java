package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.dao.EmplevateSelect;
import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplevateSelect implements ActionStd<EmplevateInfo> {
	ActionStd<EmplevateInfo> actionHelper;
	
	
	public StdEmplevateSelect(DeciTreeOption<EmplevateInfo> option) {
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
		
		return new EmplevateSelect(stmtExecOptions);
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

