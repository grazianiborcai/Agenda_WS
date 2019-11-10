package br.com.mind5.business.storeWorkTimeRange.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.dao.StoworgSelect;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoworgSelect implements ActionStd<StoworgInfo> {
	private ActionStd<StoworgInfo> actionHelper;
	
	
	public StdStoworgSelect(DeciTreeOption<StoworgInfo> option) {
		DaoStmtExec<StoworgInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoworgInfo> buildStmtExec(DeciTreeOption<StoworgInfo> option) {
		List<DaoStmtExecOption<StoworgInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoworgInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoworgInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoworgSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoworgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoworgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
