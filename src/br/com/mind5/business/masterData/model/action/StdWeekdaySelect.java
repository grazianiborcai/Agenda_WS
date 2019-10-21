package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.WeekdaySelect;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdWeekdaySelect implements ActionStd<WeekdayInfo> {
	private ActionStd<WeekdayInfo> actionHelper;
	
	
	public StdWeekdaySelect(DeciTreeOption<WeekdayInfo> option) {
		DaoStmtExec<WeekdayInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<WeekdayInfo> buildStmtExec(DeciTreeOption<WeekdayInfo> option) {
		List<DaoStmtExecOption<WeekdayInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(WeekdayInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<WeekdayInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new WeekdaySelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<WeekdayInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WeekdayInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
