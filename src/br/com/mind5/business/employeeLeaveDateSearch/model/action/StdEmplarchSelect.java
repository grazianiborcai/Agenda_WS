package br.com.mind5.business.employeeLeaveDateSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.dao.EmplarchSelect;
import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplarchSelect implements ActionStd<EmplarchInfo> {
	ActionStd<EmplarchInfo> actionHelper;
	
	
	public StdEmplarchSelect(DeciTreeOption<EmplarchInfo> option) {
		DaoStmtExec_<EmplarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmplarchInfo> buildStmtExec(DeciTreeOption<EmplarchInfo> option) {
		List<DaoStmtExecOption<EmplarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmplarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmplarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmplarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmplarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}

