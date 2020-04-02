package br.com.mind5.business.employee.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.dao.EmpInsert;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpInsert implements ActionStdV1<EmpInfo> {
	ActionStdV1<EmpInfo> actionHelper;
	
	
	public StdEmpInsert(DeciTreeOption<EmpInfo> option) {
		DaoStmtExec_<EmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmpInfo> buildStmtExec(DeciTreeOption<EmpInfo> option) {
		List<DaoStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
