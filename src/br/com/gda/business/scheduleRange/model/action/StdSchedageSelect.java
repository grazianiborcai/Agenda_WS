package br.com.gda.business.scheduleRange.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleRange.dao.SchedageSelect;
import br.com.gda.business.scheduleRange.info.SchedageInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedageSelect implements ActionStd<SchedageInfo> {
	private ActionStd<SchedageInfo> actionHelper;
	
	
	public StdSchedageSelect(DeciTreeOption<SchedageInfo> option) {
		DaoStmtExec<SchedageInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SchedageInfo> buildStmtExec(DeciTreeOption<SchedageInfo> option) {
		List<DaoStmtExecOption<SchedageInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedageInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedageInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedageSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedageInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedageInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
