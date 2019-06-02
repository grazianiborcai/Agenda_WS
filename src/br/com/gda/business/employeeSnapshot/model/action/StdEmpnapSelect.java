package br.com.gda.business.employeeSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeSnapshot.dao.EmpnapSelect;
import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpnapSelect implements ActionStd<EmpnapInfo> {
	ActionStd<EmpnapInfo> actionHelper;
	
	
	public StdEmpnapSelect(DeciTreeOption<EmpnapInfo> option) {
		DaoStmtExec<EmpnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpnapInfo> buildStmtExec(DeciTreeOption<EmpnapInfo> option) {
		List<DaoStmtExecOption<EmpnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpnapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
