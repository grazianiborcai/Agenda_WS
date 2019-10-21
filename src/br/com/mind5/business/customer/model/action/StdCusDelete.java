package br.com.mind5.business.customer.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.dao.CusDelete;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusDelete implements ActionStd<CusInfo> {
	private ActionStd<CusInfo> actionHelper;
	
	
	public StdCusDelete(DeciTreeOption<CusInfo> option) {
		DaoStmtExec<CusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CusInfo> buildStmtExec(DeciTreeOption<CusInfo> option) {
		List<DaoStmtExecOption<CusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
