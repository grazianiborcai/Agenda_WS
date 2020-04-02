package br.com.mind5.business.storeWorkTime.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.dao.StowotmInsert;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotmInsert implements ActionStdV1<StowotmInfo> {
	private ActionStdV1<StowotmInfo> actionHelper;
	
	
	public StdStowotmInsert(DeciTreeOption<StowotmInfo> option) {
		DaoStmtExec_<StowotmInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StowotmInfo> buildStmtExec(DeciTreeOption<StowotmInfo> option) {
		List<DaoStmtExecOption<StowotmInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StowotmInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StowotmInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StowotmInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StowotmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StowotmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
