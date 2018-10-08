package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.dao.StoreLDateSelectRange;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreLDateSelectRange implements ActionStd<StoreLDateInfo> {
	private ActionStd<StoreLDateInfo> actionHelper;
	
	
	public ActionStoreLDateSelectRange(DeciTreeOption<StoreLDateInfo> option) {
		DaoStmtExec<StoreLDateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
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
		
		return new StoreLDateSelectRange(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoreLDateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreLDateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}	
