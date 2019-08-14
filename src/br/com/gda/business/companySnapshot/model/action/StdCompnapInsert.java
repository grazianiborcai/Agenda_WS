package br.com.gda.business.companySnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.companySnapshot.dao.CompnapInsert;
import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCompnapInsert implements ActionStd<CompnapInfo> {
	ActionStd<CompnapInfo> actionHelper;
	
	
	public StdCompnapInsert(DeciTreeOption<CompnapInfo> option) {
		DaoStmtExec<CompnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CompnapInfo> buildStmtExec(DeciTreeOption<CompnapInfo> option) {
		List<DaoStmtExecOption<CompnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CompnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CompnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CompnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CompnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
