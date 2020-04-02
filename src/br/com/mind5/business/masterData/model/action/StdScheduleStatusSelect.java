package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.ScheduleStatusSelect;
import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdScheduleStatusSelect implements ActionStdV1<ScheduleStatusInfo> {
	private ActionStdV1<ScheduleStatusInfo> actionHelper;
	
	
	public StdScheduleStatusSelect(DeciTreeOption<ScheduleStatusInfo> option) {
		DaoStmtExec_<ScheduleStatusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<ScheduleStatusInfo> buildStmtExec(DeciTreeOption<ScheduleStatusInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<ScheduleStatusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ScheduleStatusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
