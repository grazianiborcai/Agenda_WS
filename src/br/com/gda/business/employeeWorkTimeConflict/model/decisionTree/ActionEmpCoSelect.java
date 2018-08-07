package br.com.gda.business.employeeWorkTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTimeConflict.dao.EmpCoSelect;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionEmpCoSelect implements DeciAction<EmpCoInfo> {
	private DeciAction<EmpCoInfo> actionHelper;
	
	
	public ActionEmpCoSelect(DeciTreeOption<EmpCoInfo> option) {
		DaoStmtExec<EmpCoInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpCoInfo> buildStmtExec(DeciTreeOption<EmpCoInfo> option) {
		List<DaoStmtExecOption<EmpCoInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpCoInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpCoInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpCoSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<EmpCoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpCoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
