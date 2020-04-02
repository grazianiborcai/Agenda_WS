package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.dao.EmpwocoSelect;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwocoSelect implements ActionStdV1<EmpwocoInfo> {
	private ActionStdV1<EmpwocoInfo> actionHelper;
	
	
	public StdEmpwocoSelect(DeciTreeOption<EmpwocoInfo> option) {
		DaoStmtExec_<EmpwocoInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmpwocoInfo> buildStmtExec(DeciTreeOption<EmpwocoInfo> option) {
		List<DaoStmtExecOption<EmpwocoInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpwocoInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpwocoInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpwocoSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpwocoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpwocoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
