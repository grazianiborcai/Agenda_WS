package br.com.mind5.business.scheduleList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleList.dao.SchedistSelect;
import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedistSelect implements ActionStd<SchedistInfo> {
	private ActionStd<SchedistInfo> actionHelper;
	
	
	public StdSchedistSelect(DeciTreeOption<SchedistInfo> option) {
		DaoStmtExec<SchedistInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SchedistInfo> buildStmtExec(DeciTreeOption<SchedistInfo> option) {
		List<DaoStmtExecOption<SchedistInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedistInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedistInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedistSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
