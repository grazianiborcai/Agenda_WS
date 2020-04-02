package br.com.mind5.business.scheduleRange.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleRange.dao.SchedageSelect;
import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedageSelect implements ActionStd<SchedageInfo> {
	private ActionStd<SchedageInfo> actionHelper;
	
	
	public StdSchedageSelect(DeciTreeOption<SchedageInfo> option) {
		DaoStmtExec_<SchedageInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SchedageInfo> buildStmtExec(DeciTreeOption<SchedageInfo> option) {
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
