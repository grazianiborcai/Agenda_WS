package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.dao.EmplateUpdate;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplateUpdate implements ActionStd<EmplateInfo> {
	ActionStd<EmplateInfo> actionHelper;
	
	
	public StdEmplateUpdate(DeciTreeOption<EmplateInfo> option) {
		DaoStmtExec_<EmplateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmplateInfo> buildStmtExec(DeciTreeOption<EmplateInfo> option) {
		List<DaoStmtExecOption<EmplateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmplateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmplateInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmplateUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmplateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
