package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.dao.StoreLDateUpdate;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionStoreLDateUpdate implements DeciAction<StoreLDateInfo> {
	DeciAction<StoreLDateInfo> actionHelper;
	
	
	public ActionStoreLDateUpdate(DeciTreeOption<StoreLDateInfo> option) {
		SqlStmtExec<StoreLDateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelper<>(sqlStmtExecutor);
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
		
		return new StoreLDateUpdate(stmtExecOptions);
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
