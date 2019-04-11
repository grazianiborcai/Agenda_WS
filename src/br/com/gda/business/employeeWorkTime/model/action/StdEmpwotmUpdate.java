package br.com.gda.business.employeeWorkTime.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.dao.EmpwotmUpdate;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpwotmUpdate implements ActionStd<EmpwotmInfo> {
	private ActionStd<EmpwotmInfo> actionHelper;
	
	
	public StdEmpwotmUpdate(DeciTreeOption<EmpwotmInfo> option) {
		DaoStmtExec<EmpwotmInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpwotmInfo> buildStmtExec(DeciTreeOption<EmpwotmInfo> option) {
		List<DaoStmtExecOption<EmpwotmInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpwotmInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpwotmInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpwotmUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpwotmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwotmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
