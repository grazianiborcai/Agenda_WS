package br.com.gda.business.orderItemSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderItemSnapshot.dao.OrdemrapInsert;
import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrdemrapInsert implements ActionStd<OrdemrapInfo> {
	private ActionStd<OrdemrapInfo> actionHelper;
	
	
	public StdOrdemrapInsert(DeciTreeOption<OrdemrapInfo> option) {
		DaoStmtExec<OrdemrapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OrdemrapInfo> buildStmtExec(DeciTreeOption<OrdemrapInfo> option) {
		List<DaoStmtExecOption<OrdemrapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrdemrapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrdemrapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrdemrapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdemrapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdemrapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
