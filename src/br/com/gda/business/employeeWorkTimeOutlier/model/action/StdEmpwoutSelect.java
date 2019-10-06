package br.com.gda.business.employeeWorkTimeOutlier.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTimeOutlier.dao.EmpwoutSelect;
import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdEmpwoutSelect implements ActionStd<EmpwoutInfo> {
	private ActionStd<EmpwoutInfo> actionHelper;
	
	
	public StdEmpwoutSelect(DeciTreeOption<EmpwoutInfo> option) {
		DaoStmtExec<EmpwoutInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpwoutInfo> buildStmtExec(DeciTreeOption<EmpwoutInfo> option) {
		List<DaoStmtExecOption<EmpwoutInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpwoutInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpwoutInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpwoutSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpwoutInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwoutInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
