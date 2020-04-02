package br.com.mind5.business.employeeWorkTimeRange.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.dao.EmpworgSelect;
import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpworgSelect implements ActionStdV1<EmpworgInfo> {
	private ActionStdV1<EmpworgInfo> actionHelper;
	
	
	public StdEmpworgSelect(DeciTreeOption<EmpworgInfo> option) {
		DaoStmtExec_<EmpworgInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmpworgInfo> buildStmtExec(DeciTreeOption<EmpworgInfo> option) {
		List<DaoStmtExecOption<EmpworgInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpworgInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpworgInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpworgSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpworgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpworgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
