package br.com.gda.business.scheduleSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleSearch.dao.SchedarchSelect;
import br.com.gda.business.scheduleSearch.info.SchedarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedarchSelect implements ActionStd<SchedarchInfo> {
	private ActionStd<SchedarchInfo> actionHelper;
	
	
	public StdSchedarchSelect(DeciTreeOption<SchedarchInfo> option) {
		DaoStmtExec<SchedarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SchedarchInfo> buildStmtExec(DeciTreeOption<SchedarchInfo> option) {
		List<DaoStmtExecOption<SchedarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
