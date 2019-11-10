package br.com.mind5.business.storeWorkTimeSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.dao.StowotarchSelect;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotarchSelect implements ActionStd<StowotarchInfo> {
	private ActionStd<StowotarchInfo> actionHelper;
	
	
	public StdStowotarchSelect(DeciTreeOption<StowotarchInfo> option) {
		DaoStmtExec<StowotarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StowotarchInfo> buildStmtExec(DeciTreeOption<StowotarchInfo> option) {
		List<DaoStmtExecOption<StowotarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StowotarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StowotarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StowotarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StowotarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StowotarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
