package br.com.mind5.business.calendarDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.dao.CalateSelect;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalateSelect implements ActionStd<CalateInfo> {
	private ActionStd<CalateInfo> actionHelper;
	
	
	public StdCalateSelect(DeciTreeOption<CalateInfo> option) {
		DaoStmtExec<CalateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CalateInfo> buildStmtExec(DeciTreeOption<CalateInfo> option) {
		List<DaoStmtExecOption<CalateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CalateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CalateInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CalateSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CalateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CalateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
