package br.com.mind5.business.company.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.dao.CompDelete;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompDelete implements ActionStd<CompInfo> {
	ActionStd<CompInfo> actionHelper;
	
	
	public StdCompDelete(DeciTreeOption<CompInfo> option) {
		DaoStmtExec<CompInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CompInfo> buildStmtExec(DeciTreeOption<CompInfo> option) {
		List<DaoStmtExecOption<CompInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CompInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CompInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CompDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CompInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
