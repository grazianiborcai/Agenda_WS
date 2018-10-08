package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.TimezoneSelect;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionTimezoneSelect implements ActionStd<TimezoneInfo> {
	private ActionStd<TimezoneInfo> actionHelper;
	
	
	public ActionTimezoneSelect(DeciTreeOption<TimezoneInfo> option) {
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
