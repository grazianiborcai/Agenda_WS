package br.com.mind5.business.employeeMaterial.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.dao.EmpmatUpdate;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmatUpdate implements ActionStdV1<EmpmatInfo> {
	ActionStdV1<EmpmatInfo> actionHelper;
	
	
	public StdEmpmatUpdate(DeciTreeOption<EmpmatInfo> option) {
		DaoStmtExec_<EmpmatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmpmatInfo> buildStmtExec(DeciTreeOption<EmpmatInfo> option) {
		List<DaoStmtExecOption<EmpmatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpmatInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpmatInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpmatUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmpmatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpmatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
