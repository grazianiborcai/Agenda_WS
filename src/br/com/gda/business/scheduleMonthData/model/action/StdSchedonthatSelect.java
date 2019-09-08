package br.com.gda.business.scheduleMonthData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleMonthData.dao.SchedonthatSelect;
import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedonthatSelect implements ActionStd<SchedonthatInfo> {
	private ActionStd<SchedonthatInfo> actionHelper;
	
	
	public StdSchedonthatSelect(DeciTreeOption<SchedonthatInfo> option) {
		DaoStmtExec<SchedonthatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SchedonthatInfo> buildStmtExec(DeciTreeOption<SchedonthatInfo> option) {
		List<DaoStmtExecOption<SchedonthatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedonthatInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedonthatInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedonthatSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedonthatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedonthatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
