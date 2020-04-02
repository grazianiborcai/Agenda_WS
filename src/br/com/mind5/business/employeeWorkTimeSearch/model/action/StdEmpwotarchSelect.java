package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.dao.EmpwotarchSelect;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwotarchSelect implements ActionStd<EmpwotarchInfo> {
	private ActionStd<EmpwotarchInfo> actionHelper;
	
	
	public StdEmpwotarchSelect(DeciTreeOption<EmpwotarchInfo> option) {
		DaoStmtExec_<EmpwotarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmpwotarchInfo> buildStmtExec(DeciTreeOption<EmpwotarchInfo> option) {
		List<DaoStmtExecOption<EmpwotarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpwotarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpwotarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpwotarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpwotarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwotarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
