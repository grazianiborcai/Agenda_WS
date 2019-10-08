package br.com.gda.business.storeLeaveDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.dao.StolevateSelectKey;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStolevateSelectKey implements ActionStd<StolevateInfo> {
	private ActionStd<StolevateInfo> actionHelper;
	
	
	public StdStolevateSelectKey(DeciTreeOption<StolevateInfo> option) {
		DaoStmtExec<StolevateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StolevateInfo> buildStmtExec(DeciTreeOption<StolevateInfo> option) {
		List<DaoStmtExecOption<StolevateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StolevateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StolevateInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StolevateSelectKey(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolevateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolevateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}	
