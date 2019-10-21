package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.TimezoneSelect;
import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdTimezoneSelect implements ActionStd<TimezoneInfo> {
	private ActionStd<TimezoneInfo> actionHelper;
	
	
	public StdTimezoneSelect(DeciTreeOption<TimezoneInfo> option) {
		DaoStmtExec<TimezoneInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<TimezoneInfo> buildStmtExec(DeciTreeOption<TimezoneInfo> option) {
		List<DaoStmtExecOption<TimezoneInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(TimezoneInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<TimezoneInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new TimezoneSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<TimezoneInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<TimezoneInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
