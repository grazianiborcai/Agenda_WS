package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.dao.StoreLDateInsert;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionStoreLDateInsert implements DeciAction<StoreLDateInfo> {
	DeciAction<StoreLDateInfo> actionHelper;
	
	
	public ActionStoreLDateInsert(DeciTreeOption<StoreLDateInfo> option) {
		SqlStmtExec<StoreLDateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<StoreLDateInfo> buildStmtExec(DeciTreeOption<StoreLDateInfo> option) {
		List<SqlStmtExecOption<StoreLDateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreLDateInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<StoreLDateInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreLDateInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreLDateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreLDateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
