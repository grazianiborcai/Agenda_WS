package br.com.gda.business.company.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.dao.CompUpdate;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCompUpdate implements ActionStd<CompInfo> {
	ActionStd<CompInfo> actionHelper;
	
	
	public StdCompUpdate(DeciTreeOption<CompInfo> option) {
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
		
		return new CompUpdate(stmtExecOptions);
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
