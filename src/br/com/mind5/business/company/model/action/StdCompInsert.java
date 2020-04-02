package br.com.mind5.business.company.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.dao.CompInsert;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompInsert implements ActionStdV1<CompInfo> {
	ActionStdV1<CompInfo> actionHelper;
	
	
	public StdCompInsert(DeciTreeOption<CompInfo> option) {
		DaoStmtExec_<CompInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CompInfo> buildStmtExec(DeciTreeOption<CompInfo> option) {
		List<DaoStmtExecOption<CompInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CompInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CompInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CompInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CompInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
