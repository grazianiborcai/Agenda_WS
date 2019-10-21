package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.MonthSelect;
import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMonthSelect implements ActionStd<MonthInfo> {
	private ActionStd<MonthInfo> actionHelper;
	
	
	public StdMonthSelect(DeciTreeOption<MonthInfo> option) {
		DaoStmtExec<MonthInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MonthInfo> buildStmtExec(DeciTreeOption<MonthInfo> option) {
		List<DaoStmtExecOption<MonthInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MonthInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MonthInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MonthSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MonthInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MonthInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
