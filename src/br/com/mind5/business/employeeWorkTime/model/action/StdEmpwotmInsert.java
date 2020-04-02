package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.dao.EmpwotmInsert;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwotmInsert implements ActionStdV1<EmpwotmInfo> {
	private ActionStdV1<EmpwotmInfo> actionHelper;
	
	
	public StdEmpwotmInsert(DeciTreeOption<EmpwotmInfo> option) {
		DaoStmtExec_<EmpwotmInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmpwotmInfo> buildStmtExec(DeciTreeOption<EmpwotmInfo> option) {
		List<DaoStmtExecOption<EmpwotmInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpwotmInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpwotmInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpwotmInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpwotmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwotmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
