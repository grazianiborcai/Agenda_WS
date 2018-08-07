package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.dao.StoreLDateInsert;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionStoreLDateInsert implements DeciAction<StoreLDateInfo> {
	private DeciAction<StoreLDateInfo> actionHelper;
	
	
	public ActionStoreLDateInsert(DeciTreeOption<StoreLDateInfo> option) {
		DaoStmtExec<StoreLDateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoreLDateInfo> buildStmtExec(DeciTreeOption<StoreLDateInfo> option) {
		List<DaoStmtExecOption<StoreLDateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreLDateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoreLDateInfo> stmtExecOption = new DaoStmtExecOption<>();
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
