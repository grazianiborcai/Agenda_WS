package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.dao.EmpwocoSelect;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwocoSelect implements ActionStd<EmpwocoInfo> {
	private ActionStd<EmpwocoInfo> actionHelper;
	
	
	public StdEmpwocoSelect(DeciTreeOption<EmpwocoInfo> option) {
		DaoStmtExec<EmpwocoInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpwocoInfo> buildStmtExec(DeciTreeOption<EmpwocoInfo> option) {
		List<DaoStmtExecOption<EmpwocoInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpwocoInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpwocoInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpwocoSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpwocoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwocoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
