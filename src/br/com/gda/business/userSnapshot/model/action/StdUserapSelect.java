package br.com.gda.business.userSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot.dao.UserapSelect;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdUserapSelect implements ActionStd<UserapInfo> {
	private ActionStd<UserapInfo> actionHelper;
	
	
	public StdUserapSelect(DeciTreeOption<UserapInfo> option) {
		DaoStmtExec<UserapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<UserapInfo> buildStmtExec(DeciTreeOption<UserapInfo> option) {
		List<DaoStmtExecOption<UserapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(UserapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<UserapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new UserapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
