package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.dao.CusInsert;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class ActionCusInsert implements DeciAction<CusInfo> {
	DeciAction<CusInfo> actionHelper;
	
	
	public ActionCusInsert(DeciTreeOption<CusInfo> option) {
		SqlStmtExec<CusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<CusInfo> buildStmtExec(DeciTreeOption<CusInfo> option) {
		List<SqlStmtExecOption<CusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<CusInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<CusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
