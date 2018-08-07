package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpUpdate;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionEmpUpdate implements DeciAction<EmpInfo> {
	DeciAction<EmpInfo> actionHelper;
	
	
	public ActionEmpUpdate(DeciTreeOption<EmpInfo> option) {
		DaoStmtExec<EmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
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
		
		return new EmpUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<EmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
