package br.com.mind5.business.scheduleMonthData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.dao.SchedonthatSelect;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedonthatSelect implements ActionStd<SchedonthatInfo> {
	private ActionStd<SchedonthatInfo> actionHelper;
	
	
	public StdSchedonthatSelect(DeciTreeOption<SchedonthatInfo> option) {
		DaoStmtExec_<SchedonthatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SchedonthatInfo> buildStmtExec(DeciTreeOption<SchedonthatInfo> option) {
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
