package br.com.mind5.business.employeeMaterial.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.dao.EmpmatDelete;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmatDelete implements ActionStd<EmpmatInfo> {
	private ActionStd<EmpmatInfo> actionHelper;
	
	
	public StdEmpmatDelete(DeciTreeOption<EmpmatInfo> option) {
		DaoStmtExec<EmpmatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpmatInfo> buildStmtExec(DeciTreeOption<EmpmatInfo> option) {
		List<DaoStmtExecOption<EmpmatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpmatInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpmatInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpmatDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpmatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpmatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
