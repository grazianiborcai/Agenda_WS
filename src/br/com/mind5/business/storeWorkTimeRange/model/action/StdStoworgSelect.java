package br.com.mind5.business.storeWorkTimeRange.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.dao.StoworgSelect;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoworgSelect implements ActionStdV1<StoworgInfo> {
	private ActionStdV1<StoworgInfo> actionHelper;
	
	
	public StdStoworgSelect(DeciTreeOption<StoworgInfo> option) {
		DaoStmtExec_<StoworgInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StoworgInfo> buildStmtExec(DeciTreeOption<StoworgInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<StoworgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoworgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
