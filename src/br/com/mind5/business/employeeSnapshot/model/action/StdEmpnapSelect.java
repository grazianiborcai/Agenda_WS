package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.dao.EmpnapSelect;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpnapSelect implements ActionStd<EmpnapInfo> {
	ActionStd<EmpnapInfo> actionHelper;
	
	
	public StdEmpnapSelect(DeciTreeOption<EmpnapInfo> option) {
		DaoStmtExec_<EmpnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmpnapInfo> buildStmtExec(DeciTreeOption<EmpnapInfo> option) {
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
