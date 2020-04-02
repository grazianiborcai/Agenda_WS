package br.com.mind5.business.scheduleLine.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.dao.SchedineInsert;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedineInsert implements ActionStdV1<SchedineInfo> {
	private ActionStdV1<SchedineInfo> actionHelper;
	
	
	public StdSchedineInsert(DeciTreeOption<SchedineInfo> option) {
		DaoStmtExec_<SchedineInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SchedineInfo> buildStmtExec(DeciTreeOption<SchedineInfo> option) {
		List<DaoStmtExecOption<SchedineInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedineInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedineInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedineInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<SchedineInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedineInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
