package br.com.gda.business.ownerSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.ownerSnapshot.dao.OwnerapInsert;
import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOwnerapInsert implements ActionStd<OwnerapInfo> {
	private ActionStd<OwnerapInfo> actionHelper;
	
	
	public StdOwnerapInsert(DeciTreeOption<OwnerapInfo> option) {
		DaoStmtExec<OwnerapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OwnerapInfo> buildStmtExec(DeciTreeOption<OwnerapInfo> option) {
		List<DaoStmtExecOption<OwnerapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwnerapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OwnerapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwnerapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnerapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
