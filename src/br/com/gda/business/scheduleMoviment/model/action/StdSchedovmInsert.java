package br.com.gda.business.scheduleMoviment.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleMoviment.dao.SchedovmInsert;
import br.com.gda.business.scheduleMoviment.info.SchedovmInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedovmInsert implements ActionStd<SchedovmInfo> {
	private ActionStd<SchedovmInfo> actionHelper;
	
	
	public StdSchedovmInsert(DeciTreeOption<SchedovmInfo> option) {
		DaoStmtExec<SchedovmInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SchedovmInfo> buildStmtExec(DeciTreeOption<SchedovmInfo> option) {
		List<DaoStmtExecOption<SchedovmInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedovmInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedovmInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedovmInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedovmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedovmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
