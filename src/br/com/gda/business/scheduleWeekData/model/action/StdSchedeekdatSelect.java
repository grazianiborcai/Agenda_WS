package br.com.gda.business.scheduleWeekData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleWeekData.dao.SchedeekdatSelect;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedeekdatSelect implements ActionStd<SchedeekdatInfo> {
	private ActionStd<SchedeekdatInfo> actionHelper;
	
	
	public StdSchedeekdatSelect(DeciTreeOption<SchedeekdatInfo> option) {
		DaoStmtExec<SchedeekdatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SchedeekdatInfo> buildStmtExec(DeciTreeOption<SchedeekdatInfo> option) {
		List<DaoStmtExecOption<SchedeekdatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedeekdatInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedeekdatInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedeekdatSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedeekdatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedeekdatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
