package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.dao.EmpwoutSelect;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwoutSelect implements ActionStdV1<EmpwoutInfo> {
	private ActionStdV1<EmpwoutInfo> actionHelper;
	
	
	public StdEmpwoutSelect(DeciTreeOption<EmpwoutInfo> option) {
		DaoStmtExec_<EmpwoutInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmpwoutInfo> buildStmtExec(DeciTreeOption<EmpwoutInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpwoutInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwoutInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
