package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.TimezoneSelect;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class ActionTimezoneSelect implements DeciAction<TimezoneInfo> {
	private DeciAction<TimezoneInfo> actionHelper;
	
	
	public ActionTimezoneSelect(DeciTreeOption<TimezoneInfo> option) {
		SqlStmtExec<TimezoneInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<TimezoneInfo> buildStmtExec(DeciTreeOption<TimezoneInfo> option) {
		List<SqlStmtExecOption<TimezoneInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(TimezoneInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<TimezoneInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new TimezoneSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<TimezoneInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<TimezoneInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
