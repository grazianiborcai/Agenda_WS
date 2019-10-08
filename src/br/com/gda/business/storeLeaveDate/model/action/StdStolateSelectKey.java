package br.com.gda.business.storeLeaveDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.dao.StolateSelectKey;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStolateSelectKey implements ActionStd<StolateInfo> {
	private ActionStd<StolateInfo> actionHelper;
	
	
	public StdStolateSelectKey(DeciTreeOption<StolateInfo> option) {
		DaoStmtExec<StolateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StolateInfo> buildStmtExec(DeciTreeOption<StolateInfo> option) {
		List<DaoStmtExecOption<StolateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StolateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StolateInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StolateSelectKey(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}	
