package br.com.mind5.business.storeWorkTimeSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.dao.StowotarchSelect;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotarchSelect implements ActionStdV1<StowotarchInfo> {
	private ActionStdV1<StowotarchInfo> actionHelper;
	
	
	public StdStowotarchSelect(DeciTreeOption<StowotarchInfo> option) {
		DaoStmtExec_<StowotarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StowotarchInfo> buildStmtExec(DeciTreeOption<StowotarchInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<StowotarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StowotarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
