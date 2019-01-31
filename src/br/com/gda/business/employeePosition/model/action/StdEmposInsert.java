package br.com.gda.business.employeePosition.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeePosition.dao.EmposInsert;
import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmposInsert implements ActionStd<EmposInfo> {
	private ActionStd<EmposInfo> actionHelper;
	
	
	public StdEmposInsert(DeciTreeOption<EmposInfo> option) {
		DaoStmtExec<EmposInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmposInfo> buildStmtExec(DeciTreeOption<EmposInfo> option) {
		List<DaoStmtExecOption<EmposInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmposInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmposInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmposInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmposInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmposInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
