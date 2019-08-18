package br.com.gda.business.scheduleLine.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLine.dao.SchedineUpdate;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedineUpdate implements ActionStd<SchedineInfo> {
	private ActionStd<SchedineInfo> actionHelper;
	
	
	public StdSchedineUpdate(DeciTreeOption<SchedineInfo> option) {
		DaoStmtExec<SchedineInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SchedineInfo> buildStmtExec(DeciTreeOption<SchedineInfo> option) {
		List<DaoStmtExecOption<SchedineInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedineInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedineInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedineUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedineInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedineInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
