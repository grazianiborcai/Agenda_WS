package br.com.mind5.business.employeeSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.dao.EmparchSelect;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmparchSelect implements ActionStdV1<EmparchInfo> {
	ActionStdV1<EmparchInfo> actionHelper;
	
	
	public StdEmparchSelect(DeciTreeOption<EmparchInfo> option) {
		DaoStmtExec_<EmparchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmparchInfo> buildStmtExec(DeciTreeOption<EmparchInfo> option) {
		List<DaoStmtExecOption<EmparchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmparchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmparchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmparchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
