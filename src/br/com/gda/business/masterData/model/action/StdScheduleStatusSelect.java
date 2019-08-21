package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.ScheduleStatusSelect;
import br.com.gda.business.masterData.info.ScheduleStatusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdScheduleStatusSelect implements ActionStd<ScheduleStatusInfo> {
	private ActionStd<ScheduleStatusInfo> actionHelper;
	
	
	public StdScheduleStatusSelect(DeciTreeOption<ScheduleStatusInfo> option) {
		DaoStmtExec<ScheduleStatusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<ScheduleStatusInfo> buildStmtExec(DeciTreeOption<ScheduleStatusInfo> option) {
		List<DaoStmtExecOption<ScheduleStatusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(ScheduleStatusInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<ScheduleStatusInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new ScheduleStatusSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<ScheduleStatusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ScheduleStatusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
