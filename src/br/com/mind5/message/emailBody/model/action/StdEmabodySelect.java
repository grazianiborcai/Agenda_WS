package br.com.mind5.message.emailBody.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.message.emailBody.dao.EmabodySelect;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmabodySelect implements ActionStd<EmabodyInfo> {
	private ActionStd<EmabodyInfo> actionHelper;
	
	
	public StdEmabodySelect(DeciTreeOption<EmabodyInfo> option) {
		DaoStmtExec<EmabodyInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmabodyInfo> buildStmtExec(DeciTreeOption<EmabodyInfo> option) {
		List<DaoStmtExecOption<EmabodyInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmabodyInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmabodyInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmabodySelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmabodyInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmabodyInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
