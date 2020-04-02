package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.dao.EmpnapInsert;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpnapInsert implements ActionStdV1<EmpnapInfo> {
	ActionStdV1<EmpnapInfo> actionHelper;
	
	
	public StdEmpnapInsert(DeciTreeOption<EmpnapInfo> option) {
		DaoStmtExec_<EmpnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
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
		
		return new EmpnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
