package br.com.gda.business.customer.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.dao.CusDelete;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
