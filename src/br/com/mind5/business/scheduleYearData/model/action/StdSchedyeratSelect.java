package br.com.mind5.business.scheduleYearData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYearData.dao.SchedyeratSelect;
import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedyeratSelect implements ActionStdV1<SchedyeratInfo> {
	private ActionStdV1<SchedyeratInfo> actionHelper;
	
	
	public StdSchedyeratSelect(DeciTreeOption<SchedyeratInfo> option) {
		DaoStmtExec_<SchedyeratInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SchedyeratInfo> buildStmtExec(DeciTreeOption<SchedyeratInfo> option) {
		List<DaoStmtExecOption<SchedyeratInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedyeratInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedyeratInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedyeratSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<SchedyeratInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedyeratInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
